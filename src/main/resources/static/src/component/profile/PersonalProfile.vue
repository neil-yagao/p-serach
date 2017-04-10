<template>
	<div>
  		<hr>
		<div class="row">
			<div class="col-md-2">
				<a class="thumbnail">
					<img :src="data.img" data-holder-rendered="true"> 
				</a>
			</div>
			<div class="col-md-8">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">需服用药物</h3>
					</div>
					<div class="panel-body">
						<ul class="list-group">
						  <li class="list-group-item" v-for="medical in data.medicals">
						    <span class="badge">{{medical.amount}}</span>
						    {{medical.name}}
						  </li>
						</ul>
					</div>
				</div>
				
			</div>
		</div>
	</div>
</template>
<script>


export default {
	name:'personal-profile',
	data(){
		return {
			data:{}
			
		}
	},
	mounted: function(){
		var id = this.$route.params[':id']	
		if(id != 'add'){}	
	}
}
</script>

<style>
	
</style>