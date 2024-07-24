<template>
  <div>
    <button v-on:click="addSite" class="btn btn-primary add">ADD</button>
    <h5 class="text-center">Site List</h5>
    <ul class="list-group">
      <li v-for="(site) in sites" v-bind:key="site.id" class="list-group-item">
        <a v-bind:href="site.url" target="_blank">{{
          site.name}}</a>
          <button v-on:click="editSite(site.id)" class="float-right btn btn-primary btn-sm mr-2">EDIT</button>
          <button v-on:click="deleteSite(site.id)" class="float-right btn btn-danger btn-sm mr-2">DEL</button>
          </li>
          </ul>
          </div>
</template>

<script>
export default {
  data(){
    return{
      sites:[]
    }
  },
  created(){
    fetch('http://localhost:8080/quest')
    .then((res)=>res.json())
    .then((data)=>{
      this.sites=data;
    })
    .catch((err)=>console.log(err))
  },
  methods:{
    addSite(){
      this.$router.push('/sites/add');
    },
    editSite(id){
      this.$router.push(`/sites/edit/${id}`);
    },
    deleteSite(id){
      fetch(`http://localhost:3000/sites/${id}`,{
        method:'DELETE',
    })
      .then(()=>{
        this.sites=this.sites.filter((site)=>site.id!==id);
      })
      .catch((err)=>console.log(err))
    }
  }
}
</script>
<style scoped>
.add{
  margin-top:10px;
}
</style>