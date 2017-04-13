<template>
	<div style="margin-top:10px">
		<div class="row"  style="max-height: 350px;overflow-y: scroll;">
			<div class="col-md-3" v-for="inmate in rows">
			    <a :href="inmate.toURL" class="thumbnail" role="button" style="text-align:center">
			    	<img :src="inmate.img" />
			    	<div class="caption" v-if="inmate.code != 'add'">
			    		<p>{{inmate.code}}</p>
			    	</div>
			    </a>
			  </div>
		</div>
	</div>
</template>
<script>
var addImg = {code:"add", toURL:"#/working/add", img:"img/add.jpg", style:"opacity: 0.3; color: gray;  vertical-align: super; font-size:128px"}
import _ from 'lodash'
export default {
	name: 'inamte-panel',
	data(){
		return {
			rows:[

			]
		}
	},
    mounted: function(){
       this.$http.get("http://localhost:8080/inmate/medical/all").then((res) =>{
       		var self = this;

       		_.each(res.body, function(medicalInfo){
   				self.rows.push({
   					'code':medicalInfo.code,
   					'toURL':"#/working/detail/" + medicalInfo.code,
   					'img':'img/panda.jpg',
   					'style':''
   				})
       		});
       		this.rows = _.uniqBy(this.rows, 'code')
       		this.rows.push(addImg)
       })
    }
}
</script>