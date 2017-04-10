<template>
<div>
    <div class="page-header text-center">
        <h3>按照时间搜索</h3>
        
    </div>
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <div class="input-group">
              <input type="text" class="form-control" v-model="time" placeholder="时间段">
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
    name: 'by-time-search',
    data() {
        return {
            key: '',
            time:"",
            matchingPrison:[],
            totals:[]
        }
    },
    methods: {
        doSearch: function(){

        }
    },
    components: {
        'prison-panel': InmatePanel
    }
}
</script>
<style>

</style>
