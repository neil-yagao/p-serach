<template>
	<div>
  		<hr>
		<div class="row">
			<div class="col-md-2">
				<a class="thumbnail">
					<img :src="img" data-holder-rendered="true"> 
					<div class="caption text-center">
			    		<p>{{currentCode}}</p>
			    	</div>
				</a>
			</div>
			<div class="col-md-8">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">需服用药物</h3>
					</div>
					<div class="panel-body">
						<div class="row" style="max-height: 500px;overflow-y: scroll;">
							<div class="col-md-6" v-for=" medicalInfo in medicalList" >
							<medical-panel :data="medicalInfo" :edit="false"></medical-panel>
						</div>
						</div>
					</div>
				</div>
				
			</div>
		</div>
	</div>
</template>
<script>

import MedicalPanel from './MedicalPanel.vue'
export default {
	name:'personal-profile',
	data(){
		return {
			img:'',
			medicalList:[]	,
			currentCode: ''		
		}
	},
	mounted: function(){
		var id = this.$route.params['id'];
		this.currentCode = id;
		this.$http.get('http://localhost:8080/inmate/medical/' + id).then((res)=>{
			
			this.img = 'img/panda.jpg'
			var tempObject = _.groupBy(res.body, 'time')
			for(var time in tempObject){
				this.medicalList.push({
					'time':time,
					'medicalList': tempObject[time]
				})
			}
		})
	},
	components: {
		'medical-panel': MedicalPanel
	}
}
</script>

<style>
	
</style>