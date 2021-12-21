module.exports = {
  //presets: ['@vue/cli-plugin-babel/preset' ] // default
  outputDir : "../src/main/resources/static",
  indexPath: "../static/index.html",
  devServer: {
    port : 9091,  // 접속포트
    proxy: "http://localhost:9191" // Spring Boot 내장 was 주소
  },
  chainWebpack : config =>{
    const svgRule = config.module.rule("svg");
    svgRule.uses.clear();
    svgRule.use("vue-svg-loader").loader("vue-svg-loader");
  }
}
 