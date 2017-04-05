<template>
<div>
    <div class="page-header text-center" style="margin-top:10px">
        <h3>按照时间搜索</h3>
        
    </div>
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <div class="input-group">
              <input type="text" class="form-control" v-model="time" placeholder="时间段">
              <span class="input-group-btn">
                <button class="btn btn-default" type="button" @click="doSearch()">搜索</button>
              </span>
            </div>
        </div>
    </div>
    <div class="panel panel-default" style="margin-top:20px" v-if="totals && totals.length > 0">
        <div class="panel-heading">
            <h3 class="panel-title">符合标准的服刑人员</h3>
        </div>
        <div class="panel-body">
           <div class="row" v-for="line in totals">
                <div class="col-md-3" v-for="prison in line">
                    <div class="thumbnail">
                        <img :src="prison.img" >
                        <div class="caption">
                            <p>编号：{{prison.code}}</p>
                            <p><a class="btn btn-primary" role="button">查看详细服药情况</a></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</template>
<script>
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
    }
}
</script>
<style>

</style>
