<template>
	<div class="margin">
		<div class="panel panel-default">
		<!-- Default panel contents -->
			<div class="panel-heading">服药时间：{{data.time}}<span style="float:right" class="glyphicon glyphicon-remove" @click="deletePanel()"></span></div>
			  <!-- Table -->
			<table class="table">
				<thead>
					<tr><td>#</td><td>药物</td><td>数量</td><td></td></tr>
				</thead>
				<tbody>
					<tr v-for="(medical,$index) in data.medicalList" :key="medical.name">
						<td>{{$index + 1}}</td>
						<td>{{medical.name}}</td>
						<td>{{medical.num}}</td>
						<td @click="deleteMedical(medical)" role="button"><span>&times;</span></td>
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
		deleteMedical: function(medical){
			console.info("delete:" + JSON.stringify(medical))
			this.$emit('delete-medical', {name: medical.name})
		}
	}
}	
</script>

<style>
.margin{
	margin-top:10px;
}
</style>