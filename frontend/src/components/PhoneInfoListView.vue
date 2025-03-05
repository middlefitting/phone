<template>

    <v-data-table
        :headers="headers"
        :items="phoneInfoList"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'PhoneInfoListView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            phoneInfoList : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/phoneInfoLists'))

            temp.data._embedded.phoneInfoLists.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.phoneInfoList = temp.data._embedded.phoneInfoLists;
        },
        methods: {
        }
    }
</script>

