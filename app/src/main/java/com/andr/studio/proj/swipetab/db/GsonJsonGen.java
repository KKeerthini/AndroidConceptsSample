package com.andr.studio.proj.swipetab.db;

import java.util.List;

/**
 * Created by CIPL310 on 9/29/2015.
 */
public class GsonJsonGen {
    /**
     * responseData : {"query":"Official Google Blogs","entries":[{"url":"http://googleblog.blogspot.com/feeds/posts/default","title":"<b>Official Google Blog<\/b>","contentSnippet":"<b>Official<\/b> weblog, with news of new products, events and glimpses of life inside <br>\n<b>Google<\/b>.","link":"http://googleblog.blogspot.com/"},{"url":"http://googleblog.blogspot.com/feeds/posts/default","title":"<b>Official Google Blog<\/b>: Google&#39;s look, evolved","contentSnippet":"Sep 1, 2015 <b>...<\/b> As you&#39;ll see, we&#39;ve taken the <b>Google<\/b> logo and branding, which were ..... <b>Official<\/b> <br>\n<b>Blog<\/b> Insights from Googlers into our products, technology, and&nbsp;...","link":"http://googleblog.blogspot.com/2015/09/google-update.html"},{"url":"http://googleblog.blogspot.com/feeds/posts/default","title":"<b>Official Google Blog<\/b>: G is for Google","contentSnippet":"Aug 10, 2015 <b>...<\/b> As Sergey and I wrote in the original founders letter 11 years ago, \u201c<b>Google<\/b> is not <br>\na conventional company. We do not intend to become one.","link":"http://googleblog.blogspot.com/2015/08/google-alphabet.html"},{"url":"http://gmailblog.blogspot.com/feeds/posts/default","title":"<b>Official<\/b> Gmail <b>Blog<\/b>","contentSnippet":"<b>Official Google blog<\/b> for the web-based mail service, with news, developments, <br>\nand productivity tips.","link":"http://gmailblog.blogspot.com/"},{"url":"http://googlewebmastercentral.blogspot.com/feeds/posts/default","title":"<b>Official Google<\/b> Webmaster Central <b>Blog<\/b>","contentSnippet":"The <b>official<\/b> weblog on <b>Google<\/b> crawling and indexing, and on webmaster tools, <br>\nincluding the Sitemaps facility.","link":"http://googlewebmastercentral.blogspot.com/"},{"url":"http://officialandroid.blogspot.com/feeds/posts/default","title":"<b>Official<\/b> Android <b>Blog<\/b>","contentSnippet":"If you&#39;re an existing Google Wallet user, you&#39;ll be able to access Android Pay <br>\nthrough an update to your Wallet app. ... (Cross posted on the <b>Official Google<\/b> <br>\n<b>Blog<\/b>).","link":"http://officialandroid.blogspot.com/"},{"url":"http://blog.google.org/feeds/posts/default","title":"<b>Official google<\/b>.org <b>Blog<\/b>","contentSnippet":"Jan 29, 2015 <b>...<\/b> This will be our last post on the <b>Google<\/b>.org <b>blog<\/b>. In order to make it easier for <br>\npeople to get the latest news from <b>Google<\/b> in one place, we&#39;re&nbsp;...","link":"http://blog.google.org/"},{"url":"http://insidesearch.blogspot.com/feeds/posts/default","title":"Inside Search <b>Blog<\/b>","contentSnippet":"To try it out, type (or say) \u201cconstitution\u201d into Google Search or the Google App and <br>\na box will pop up with the ..... Cross-posted on the <b>Official Google Blog<\/b>&nbsp;...","link":"http://insidesearch.blogspot.com/"},{"url":"http://feeds.feedburner.com/gtricksrss","title":"List of <b>Official Google Blogs<\/b> - Gtricks","contentSnippet":"Aug 1, 2015 <b>...<\/b> Update: Google has released official list here. Here is the list for most useful <br>\n<b>official Google blogs<\/b> in English with their descriptions:The Official&nbsp;...","link":"http://www.gtricks.com/google-tricks/list-of-official-google-blogs/"},{"url":"http://googleforwork.blogspot.com/feeds/posts/default","title":"<b>Official Google<\/b> for Work <b>Blog<\/b>","contentSnippet":"<b>Official<\/b> Weblog about <b>Google&#39;s<\/b> enterprise search appliances and other tools for <br>\nbusiness users.","link":"http://googleforwork.blogspot.com/"}]}
     * responseDetails : null
     * responseStatus : 200
     */

    private ResponseDataEntity responseData;
    private Object responseDetails;
    private int responseStatus;

    public void setResponseData(ResponseDataEntity responseData) {
        this.responseData = responseData;
    }

    public void setResponseDetails(Object responseDetails) {
        this.responseDetails = responseDetails;
    }

    public void setResponseStatus(int responseStatus) {
        this.responseStatus = responseStatus;
    }

    public ResponseDataEntity getResponseData() {
        return responseData;
    }

    public Object getResponseDetails() {
        return responseDetails;
    }

    public int getResponseStatus() {
        return responseStatus;
    }

    public static class ResponseDataEntity {
        /**
         * query : Official Google Blogs
         * entries : [{"url":"http://googleblog.blogspot.com/feeds/posts/default","title":"<b>Official Google Blog<\/b>","contentSnippet":"<b>Official<\/b> weblog, with news of new products, events and glimpses of life inside <br>\n<b>Google<\/b>.","link":"http://googleblog.blogspot.com/"},{"url":"http://googleblog.blogspot.com/feeds/posts/default","title":"<b>Official Google Blog<\/b>: Google&#39;s look, evolved","contentSnippet":"Sep 1, 2015 <b>...<\/b> As you&#39;ll see, we&#39;ve taken the <b>Google<\/b> logo and branding, which were ..... <b>Official<\/b> <br>\n<b>Blog<\/b> Insights from Googlers into our products, technology, and&nbsp;...","link":"http://googleblog.blogspot.com/2015/09/google-update.html"},{"url":"http://googleblog.blogspot.com/feeds/posts/default","title":"<b>Official Google Blog<\/b>: G is for Google","contentSnippet":"Aug 10, 2015 <b>...<\/b> As Sergey and I wrote in the original founders letter 11 years ago, \u201c<b>Google<\/b> is not <br>\na conventional company. We do not intend to become one.","link":"http://googleblog.blogspot.com/2015/08/google-alphabet.html"},{"url":"http://gmailblog.blogspot.com/feeds/posts/default","title":"<b>Official<\/b> Gmail <b>Blog<\/b>","contentSnippet":"<b>Official Google blog<\/b> for the web-based mail service, with news, developments, <br>\nand productivity tips.","link":"http://gmailblog.blogspot.com/"},{"url":"http://googlewebmastercentral.blogspot.com/feeds/posts/default","title":"<b>Official Google<\/b> Webmaster Central <b>Blog<\/b>","contentSnippet":"The <b>official<\/b> weblog on <b>Google<\/b> crawling and indexing, and on webmaster tools, <br>\nincluding the Sitemaps facility.","link":"http://googlewebmastercentral.blogspot.com/"},{"url":"http://officialandroid.blogspot.com/feeds/posts/default","title":"<b>Official<\/b> Android <b>Blog<\/b>","contentSnippet":"If you&#39;re an existing Google Wallet user, you&#39;ll be able to access Android Pay <br>\nthrough an update to your Wallet app. ... (Cross posted on the <b>Official Google<\/b> <br>\n<b>Blog<\/b>).","link":"http://officialandroid.blogspot.com/"},{"url":"http://blog.google.org/feeds/posts/default","title":"<b>Official google<\/b>.org <b>Blog<\/b>","contentSnippet":"Jan 29, 2015 <b>...<\/b> This will be our last post on the <b>Google<\/b>.org <b>blog<\/b>. In order to make it easier for <br>\npeople to get the latest news from <b>Google<\/b> in one place, we&#39;re&nbsp;...","link":"http://blog.google.org/"},{"url":"http://insidesearch.blogspot.com/feeds/posts/default","title":"Inside Search <b>Blog<\/b>","contentSnippet":"To try it out, type (or say) \u201cconstitution\u201d into Google Search or the Google App and <br>\na box will pop up with the ..... Cross-posted on the <b>Official Google Blog<\/b>&nbsp;...","link":"http://insidesearch.blogspot.com/"},{"url":"http://feeds.feedburner.com/gtricksrss","title":"List of <b>Official Google Blogs<\/b> - Gtricks","contentSnippet":"Aug 1, 2015 <b>...<\/b> Update: Google has released official list here. Here is the list for most useful <br>\n<b>official Google blogs<\/b> in English with their descriptions:The Official&nbsp;...","link":"http://www.gtricks.com/google-tricks/list-of-official-google-blogs/"},{"url":"http://googleforwork.blogspot.com/feeds/posts/default","title":"<b>Official Google<\/b> for Work <b>Blog<\/b>","contentSnippet":"<b>Official<\/b> Weblog about <b>Google&#39;s<\/b> enterprise search appliances and other tools for <br>\nbusiness users.","link":"http://googleforwork.blogspot.com/"}]
         */

        private String query;
        private List<EntriesEntity> entries;

        public void setQuery(String query) {
            this.query = query;
        }

        public void setEntries(List<EntriesEntity> entries) {
            this.entries = entries;
        }

        public String getQuery() {
            return query;
        }

        public List<EntriesEntity> getEntries() {
            return entries;
        }

        public static class EntriesEntity {
            /**
             * url : http://googleblog.blogspot.com/feeds/posts/default
             * title : <b>Official Google Blog</b>
             * contentSnippet : <b>Official</b> weblog, with news of new products, events and glimpses of life inside <br>
             <b>Google</b>.
             * link : http://googleblog.blogspot.com/
             */

            private String url;
            private String title;
            private String contentSnippet;
            private String link;

            public void setUrl(String url) {
                this.url = url;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public void setContentSnippet(String contentSnippet) {
                this.contentSnippet = contentSnippet;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public String getUrl() {
                return url;
            }

            public String getTitle() {
                return title;
            }

            public String getContentSnippet() {
                return contentSnippet;
            }

            public String getLink() {
                return link;
            }
        }
    }
}
