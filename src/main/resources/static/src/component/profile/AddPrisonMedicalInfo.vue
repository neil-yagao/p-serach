<template>
<div>
	<div class="row">
		<div class="col-md-9">
			<div class="row">
				<div class="col-md-5">
					<div class="input-group">
					  <span class="input-group-addon">服刑人员编号</span>
					  <input type="text" class="form-control" v-model="code">
					</div>
				</div>
				<div class="col-md-5 col-md-offset-1" style="visibility:hidden">
					<label>上传头像:</label><input id="fileUpload" ref="fileUpload" type="file" @change="onFileChange" style="display:inline-block;max-width:180px;margin-left:10px">
				</div>
			</div>

			<div class="panel panel-default margint">
				<div class="panel-heading"><label>添加所需使用的药物</label>	</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-md-4">
							<div class="input-group">
								<div class="input-group-btn">
									<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">服药时间 
									<span class="caret"></span></button>
									<ul class="dropdown-menu">
										<li v-for="value in qualifiedTime" @click="selectDropDown(value)"><a>{{value}}</a></li>
									</ul>
								</div><!-- /btn-group -->
								<span class="form-control">{{medicalInfo.time}}</span>
							</div>
						</div>
						<div class="col-md-5">
						    <medical-selector @selected="selectedMedicals($event)" ></medical-selector>
						</div>
						<div class="col-md-2">
							<input type="text" class="form-control" placeholder="数量" v-model="medicalInfo.num">
						</div>
						<div class="col-md-">
							<button class="btn btn-default" @click="pushInfo()">添加</button>
						</div>
					</div>
				</div>
			</div>	
			
			<div class="row margint" style="max-height: 450px;overflow-y: scroll;">
				<div class="col-md-4" v-for=" medicalInfo in medicalList" >
					<medical-panel :data="medicalInfo" @delete="deletePanel(medicalInfo)"></medical-panel>
				</div>
			</div>
		</div>	
		<div class="col-md-3">
			<a class="thumbnail" @click="uploadFile()"> <img id="header" :src="imageData" style="height: 180px; width:100%" data-holder-rendered="true"> </a>
		</div>
	</div>
	
</div>
</template>
<script type="text/javascript">
import MedicalPanel from './MedicalPanel.vue'
import MedicalSelector from './MedicalSelectionModal.vue'
import _ from "lodash"
export default {
	name :'add-prison-medical',
	data(){
		return {
			qualifiedTime:["早餐前","早餐后","午餐前","午餐后","晚餐前","晚餐后","临睡前"],
			medicalInfo:{
				time:"",
				num:""
			},
			medicalList:[],
			code:"",
			imageData:""
		}
	},
	methods:{
		onFileChange: function(event){
			var input = event.target;
            // Ensure that you have a file before attempting to read it
            if (input.files && input.files[0]) {
                // create a new FileReader to read this image and convert to base64 format
                var reader = new FileReader();
                // Define a callback function to run, when FileReader finishes its job
                reader.onload = (e) => {
                    // Note: arrow function used here, so that "this.imageData" refers to the imageData of Vue component
                    // Read image as base64 and set to imageData
                    this.imageData = e.target.result;
                    console.info(this.imageData)
                }
                // Start the reader job - read file as a data url (base64 format)
                reader.readAsDataURL(input.files[0]);
            }
		},
		uploadFile:function(){
			this.$refs.fileUpload.click()
		},
		selectDropDown: function(value){
			this.medicalInfo.time = value;
		},
		selectedMedicals:function(medicals){
			this.medicalInfo.name = medicals;
		},
		deletePanel:function(medicals){
			this.medicalList = _.filter(this.medicalList, function(m){
				return m.time != medicals.time
			})
		},
		pushInfo:function(){
			var self = this;
			var added = false;
			var tempMedicalInfo = {
				name:self.medicalInfo.name,
				num: self.medicalInfo.num
			}
			_.each(this.medicalList, function(mInfo){
				if(mInfo.time == self.medicalInfo.time){
					mInfo.medicals.push(tempMedicalInfo)
					added = true;
				}
			});
			if(!added){
				this.medicalList.push({
					time:self.medicalInfo.time,
					medicals:[tempMedicalInfo]
				})
			}
			this.medicalList = _.sortBy(this.medicalList, function(m){
				return self.qualifiedTime.indexOf(m.time)
			})
		}
	},
	components: {
		'medical-panel': MedicalPanel,
		MedicalSelector
	}
}
</script>
<style>
.margint{
  margin-top:10px;
}
.text-green {
	color: springgreen;
}
</style>
