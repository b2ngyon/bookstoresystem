<template>
    <div class="right-drawer1">
        <p>test 123</p>
    </div>
</template>

<script>
    export default {
        data() {

        },
        methods: {
            open() {
                alert('drawer');
            }
        }
    }
</script>

<style>
    .right-drawer1 {
        position: absolute;
        top: 0;
        right: 0;
        width: 0;
        overflow: hidden;
        height: 100vh;
        padding-left: 0;
        border-left: 1px solid whitesmoke;
        background: white;
        z-index: 200;
    }
</style>