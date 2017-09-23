const path = require("path");
const webpack = require("webpack");

module.exports = {
    devtool: "eval",

    // entry point of our application, within the `src` directory (which we add to resolve.modules below):
    entry: [
        "babel-polyfill", "index.jsx"
    ],

    output: {
        filename: "app.js",
        publicPath: "build",
        path: path.resolve("build")
    },

    // configure the dev server to run 
    devServer: {
        port: 3000,
        historyApiFallback: true,
        inline: true,
    },

    // tell Webpack to load Java Script files
    resolve: {
        // Look for modules in .js(x)
        extensions: [".js", ".jsx"],

        // add 'src' to the modules, so that when you import files you can do so with 'src' as the relative route
        modules: ["src", "node_modules"],
    },

    module: {
        rules: [
            {
                test: /\.jsx?$/,
                include: path.resolve(__dirname, "src"),
                exclude: /(node_modules)/,
                use: [
                    {
                        loader: "babel-loader",
                        options: {
                            "presets": ["es2016", "stage-0", "react"]
                        }
                    }
                ]
            },
            {
                test: /\.css$/,
                loader: "style-loader"
            },
            {
                test: /\.css$/,
                loader: "css-loader"
            },
        ]
    }
};
