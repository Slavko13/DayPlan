<template>
    <div>
        <div class="container-fluid">
            <div class="row">
            <button @click="change" >user</button>
            <button @click="change" >form</button>
            <div v-if="this.changer=='user'" >
                <profile :user="user"/>
            </div>
                <div v-else="this.changer=='form'" >
                    <graph-form />
                </div>
            </div>
        </div>
    </div>
</template>

<script>

    import Profile from "components/userProfile/Profile.vue"
    import GraphForm from "components/userProfile/GraphForm.vue"


    export default {
        components: {
            Profile,
            GraphForm
        },
        data() {
            return {
                user: frontendData.user,
                changer: "user"
            }
        },
        methods: {
            change() {
                if (this.changer == "user") {
                    this.changer = "form"
                }
                else {
                    this.changer = "user"
                }
            }
        }
    }

</script>

<style>

</style>