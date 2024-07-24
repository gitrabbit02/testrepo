<template>
  <div>
    <router-link to="/">Back</router-link>
    <br>
    <div class="card">
      <div class ="card-body">
        <div class="form-group">
          <input v-model="siteName" placeholder="SiteName" class="form-control">
        </div>
        <div class="form-group">
          <input v-model="siteURL" placeholder="SiteURL" class="form-control">
        </div>
        <button v-on:click="addSite()" class="btn btn-primary">ADD</button>
    </div>
    </div>
    </div>
</template>

<script>
export default {
  data(){
    return{
      siteName:'',
      siteURL:'',
    }
  },
  methods:{
    addSite(){
      if(this.siteName==='' || this.siteURL==='')
      return;

      fetch('http://localhost:8080/quest',{
        method:'GET',
        headers:{
          'Content-Type':'application/json',
          'Access-Control-Allow-Origin': 'http://localhost:8080'
        }
      })
      .then(()=>{
      this.siteName='';
      this.siteURL='';  
      this.$router.push('/');
    })
    .catch((err)=>console.log(err))
    }
  }
}
</script>