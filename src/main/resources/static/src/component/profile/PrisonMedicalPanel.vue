<template>
	<div style="margin-top:10px">
		<div class="row" v-for="row in rows">
			<div class="col-md-3" v-for="inmate in row">
			    <a :href="inmate.toURL" class="thumbnail" role="button" style="text-align:center">
			      <span class="glyphicon glyphicon-plus" :style="inmate.style"></span>
			    </a>
			  </div>
		</div>
	</div>
</template>
<script>
var addImg = {code:"add", toURL:"#/working/add", img:"img/add.jpg", style:"opacity: 0.3; color: gray;  vertical-align: super; font-size:128px"}
	export default {
		name: 'inamte-panel',
		data(){
			return {
				rows:[
					[
						addImg
					]
				]
			}
		}
	}
</script>