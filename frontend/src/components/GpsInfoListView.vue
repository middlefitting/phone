<template>

    <v-data-table
        :headers="headers"
        :items="gpsInfoList"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'GpsInfoListView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            gpsInfoList : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/gpsInfoLists'))

            temp.data._embedded.gpsInfoLists.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.gpsInfoList = temp.data._embedded.gpsInfoLists;
        },
        methods: {
        }
    }
</script>

