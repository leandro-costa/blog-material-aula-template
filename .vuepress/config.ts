import { defineUserConfig } from "vuepress";
import umlPlugin from 'markdown-it-plantuml';
import { searchPlugin } from "@vuepress/plugin-search";

import theme from "./theme.js";

export default defineUserConfig({

  base : "/blog-material-aula/",
    
  head: [
    ['link', { rel: 'manifest', href: '/blog-material-aula/manifest.webmanifest' }],
    ['meta', { name: 'theme-color', content: '#3eaf7c' }],
  ],
  lang: "pt-BR",
  title: "Blog Aulas 20231 LPR",
  description: "Material de aulas",

  extendsMarkdown: (md) => {    
    md.use(umlPlugin, {openMarker: '```plantuml', closeMarker: '```'})
  },

  theme,

  plugins: [
    searchPlugin({}),
  ],

  shouldPrefetch: false,

});
