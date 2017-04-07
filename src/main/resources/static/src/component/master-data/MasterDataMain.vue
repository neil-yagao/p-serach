<template>
	<div>
		<div class="row">
			<div class="col-md-3"> 
				<div class="list-group">
					<a href="#/working/data-edit/medical"  class="list-group-item" role="button" :class="this.$route.path.indexOf('data-edit/medical') >= 0?'list-group-item-info':''">药物管理</a>
					<a href="#/working/data-edit/inmate" class="list-group-item" role="button" :class="this.$route.path.indexOf('data-edit/inmate') >= 0?'list-group-item-info':''">服刑人员服药管理</a>
				</div>
			</div>
			<div class="col-md-9">
				<router-view></router-view>
			</div>
		</div>
	</div>
</template>
<script>
export default {
	name:'master-data',
	data(){
		return {}
	},
    methods: {
        onFileChange(e) {
            e.stopPropagation();
            e.preventDefault();
            var files = e.target.files || e.dataTransfer.files;
            if (!files.length)
                return;
            var reader = new FileReader()
            var self = this;
            reader.onload = function(e) {
                var content = e.target.result;
                //translate data into array
                //var formatedData = self.doTranslate(content)
                console.info(JSON.stringify(formatedData))
                    /*self.$http.post('/someUrl', JSON.stringify({ content: formatedData }))
                     */
            }
            reader.readAsText(files[0])
        },
        dragging(evt) {
            evt.stopPropagation();
            evt.preventDefault();
            evt.dataTransfer.dropEffect = 'copy';
        }
    }
}
</script>
<style>
.drop_zone {
    border: 2px dashed #bbb;
    -moz-border-radius: 5px;
    -webkit-border-radius: 5px;
    border-radius: 5px;
    padding: 25px;
    text-align: center;
    font: 20pt bold 'Vollkorn';
    color: #bbb;
}
</style>
