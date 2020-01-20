<template>
    <div>
        <h1>usersEdit</h1>
        {{userId}}
    </div>
</template>


<script>
    export default {
        computed :
         {
            userId() {
                return this.$route.params.id
            }
         },
       
         
    }

</script>