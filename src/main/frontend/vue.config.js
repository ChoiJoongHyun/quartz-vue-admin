module.exports = {
    publicPath: process.env.NODE_ENV === 'production'
        ? '/dist/'  //TODO context path 있을경우 추가.
        : '/',
    outputDir: '../resources/static/dist',
    lintOnSave: false,
    pages: {
        index: {
            entry: 'src/main.js',
            template: '../resources/static/_index.html',
            filename: 'index.html',
        },
    },
    devServer: {
        publicPath: '/',
        host: "0.0.0.0",
        port: 3000,
        proxy: {
            '^/': {
                target: 'http://localhost:8090',
                ws: true,
                changeOrigin: true
            }
        }
    }
}
