<template>
    <div>
        <el-row type="flex" justify="center" :gutter="20">
            <el-col :span="20">
                <el-row :span="20" justify="start">
                    <div class="bg-purple">1</div>
                </el-row>
                <el-row :span="20">
                    <el-col :span="20">
                        <div class="bg-green">1</div>
                    </el-col>
                </el-row>
            </el-col>
        </el-row>
    </div>
</template>

<script>
export default {
    data() {
        return {

        }
    }
}
</script>

<style scoped>
.bg-purple {
    background: #d3dce6;
}

.bg-green {
    background: hsl(158, 28%, 86%);
}

.el-row {
    margin-top: 25px;
}
</style>