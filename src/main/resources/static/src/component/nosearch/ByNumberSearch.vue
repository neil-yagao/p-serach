<template>
<div>
    <div class="page-header text-center">
	  	<h3>按照编号搜索</h3>
	</div>
    <div class="row">
		<div class="col-md-8 col-md-offset-2">
		    <div class="input-group">
		      <input type="text" class="form-control" v-model="id" placeholder="编号">
		      <span class="input-group-btn">
		        <button class="btn btn-default" type="button" @click="doSearch()"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
		      </span>
		    </div>
	  	</div>
  	</div>
  	<div class="row">
  		<prison-panel></prison-panel>
  	</div>
</div>
</template>
<script>
import InmatePanel from '../profile/PrisonMedicalPanel.vue'
export default {
    name: 'by-number-search',
    data() {
        return {
            id: '',
            shown : false,
            currentMedical:{}
        }
    },
    methods: {
    	doSearch: function(){
    		this.$http.get('http://localhost:8080/medical/' + this.id).then((medical) =>{
    			this.currentMedical = medical.body;
    			this.showVideoRecordWindow();
    		})
    	},
    	showVideoRecordWindow: function(){
			var x = screen.width/2 - 700/2;
			var y = screen.height/2 - 450/2;
			if(!this.shown){
				this.shown = true;
				var child = window.open('http://localhost:18080/#/recording', '_blank', 
				'location=yes,height=400,width=500,scrollbars=yes,status=yes,left='+x+',top='+y);
				var timer = setInterval(
				()=> {
					if(child && child.closed){
						this.shown = false;
					}
				}, 100)
			}
    	}
    },
    components: {
    	'prison-panel': InmatePanel
    }
}
</script>
<style>

</style>
