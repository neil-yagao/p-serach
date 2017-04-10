<template>
	<div class="margin">
		<div class="panel panel-default">
		<!-- Default panel contents -->
			<div class="panel-heading">服药时间：{{data.time}}<span style="float:right" class="glyphicon glyphicon-remove" @click="deletePanel()"></span></div>
			  <!-- Table -->
			<table class="table">
				<thead>
					<tr><td>#</td><td>药物</td><td>数量</td></tr>
				</thead>
				<tbody>
					<tr v-for="(medical,$index) in medicalList">
						<td>{{$index + 1}}</td>
						<td>{{medical.name}}</td>
						<td>{{medical.num}}</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</template>
<script>
import _ from "lodash"
export default {
	name:'medical-panel',
	props:['data'],
	methods:{
		deletePanel:function(medical){
			this.$emit('delete')
		},
	},
	computed:{
		medicalList: function(){
			var list = [];
			_.each(this.data.medicals, function(m){
				_.each(_.split(m.name,','),function(n){
					_.remove(list, function(x){
						return x.name == n;
					});
					if(m.num > 0){
						list.push({
							name:n,
							num:m.num
						})	
					}
					
				});
			})
			return list
		}
	}

}	
</script>

<style>
.margin{
	margin-top:10px;
}
</style>