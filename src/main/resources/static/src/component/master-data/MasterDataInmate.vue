<template>
<div>
	<input type="text" class="form-control" v-model="code" placeholder="人员编号">
	<table class="table table-hover">
		<thead>
			<tr>
				<td>编号</td><td>管理等级</td><td>未服药次数</td><td></td>
			</tr>
		</thead>
		<tbody>
		<!-- 	<tr v-for="matching in matchingList">
				<td>{{matching.name}}</td>
				<td><editable-input :value="matching.number" @save="updateMedicalData(matching,$event)"></editable-input></td>
			</tr> -->
		</tbody>
	</table>
	</div>
</template>
<script type="text/javascript">
export default {
	name: "inmate-records",
	data(){
		return {
			code:""
		}
	}
}
</script>