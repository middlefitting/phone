<template>

    <v-data-table
        :headers="headers"
        :items="stationInfoList"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'StationInfoListView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            stationInfoList : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/stationInfoLists'))

            temp.data._embedded.stationInfoLists.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.stationInfoList = temp.data._embedded.stationInfoLists;
        },
        methods: {
        }
    }
</script>

