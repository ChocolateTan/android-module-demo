package com.example.data_repository.entities;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class ArticleEntity {
    /**
     * _id : {"$oid":"5c0347ee57a28ba3d5b55181"}
     * guid : https://www.oschina.net/news/102310/announcing-document-layer
     * category : 综合新闻
     * create_date : 2018-12-02 10:48:14
     * description : &lt;p&gt;昨日，FoundationDB 数据库&lt;a data-cke-saved-href=&quot;https://www.foundationdb.org/blog/announcing-document-layer/&quot; target=&quot;_blank&quot; href=&quot;https://www.foundationdb.org/blog/announcing-document-layer/&quot;&gt;宣布开源&lt;/a&gt; FoundationDB Document Layer，Document Layer 是&amp;nbsp;FoundationDB 数据库中的文档数据模型，扩展了 FoundationDB 作为 Key-Value 数据库的核心功能。FoundationDB Document Layer 项目已托管至 GitHub，采用了 Apache-2.0 开源许可证，且适用于 macOS 和&amp;nbsp;Linux 平台。&lt;a data-cke-saved-href=&quot;https://foundationdb.org/download/#document-layer&quot; target=&quot;_blank&quot; href=&quot;https://foundationdb.org/download/#document-layer&quot;&gt;可点此下载二进制包&lt;/a&gt;。&lt;/p&gt;&lt;p&gt;其实严格来说，Document Layer 是&amp;nbsp;FoundationDB 数据库中的文档数据库层，实现了 MongoDB wire protocol。至于所谓“层(layers)”这个概念源于&amp;nbsp;FoundationDB 创立之初的理念 ——&amp;nbsp;FoundationDB 的愿景是从一个简单且强大的核内核开始，然后逐渐通过添加“层(layers)”以进行扩展。“层”通过为其模型的特定数据类型添加功能来扩展内核，并处理它们的访问模式。&lt;br/&gt;&lt;/p&gt;&lt;p&gt;&lt;span style=&quot;color:#24292e&quot;&gt;&lt;span style=&quot;background-color:#ffffff&quot;&gt;&lt;/span&gt;&lt;/span&gt;Document Layer&amp;nbsp;实现了 MongoDB wire protocol，可&lt;span style=&quot;color:#24292e&quot;&gt;&lt;span style=&quot;background-color:#ffffff&quot;&gt;通过现有的 MongoDB 客户端绑定使用 MongoDB API。而所有的持久性数据都会存储在 &lt;/span&gt;&lt;/span&gt;FoundationDB Key-Value&amp;nbsp;数据库&lt;span style=&quot;color:#24292e&quot;&gt;&lt;span style=&quot;background-color:#ffffff&quot;&gt;中。&lt;/span&gt;&lt;/span&gt;&lt;/p&gt;&lt;p&gt;&lt;span style=&quot;color:#24292e&quot;&gt;&lt;span style=&quot;background-color:#ffffff&quot;&gt;&lt;/span&gt;&lt;/span&gt;Document Layer&amp;nbsp;还&lt;span style=&quot;color:#24292e&quot;&gt;&lt;span style=&quot;background-color:#ffffff&quot;&gt;实现了&amp;nbsp;&lt;/span&gt;&lt;/span&gt;MongoDB&amp;nbsp;API (v 3.0.0)&amp;nbsp;&lt;span style=&quot;color:#24292e&quot;&gt;&lt;span style=&quot;background-color:#ffffff&quot;&gt;的一个子集，但两者存在一些&lt;a data-cke-saved-href=&quot;https://foundationdb.github.io/fdb-document-layer/known-differences.html&quot; href=&quot;https://foundationdb.github.io/fdb-document-layer/known-differences.html&quot; target=&quot;_blank&quot;&gt;差异&lt;/a&gt;。该子集主要侧重于 CRUD 操作、索引和事务这些方面。&lt;/span&gt;&lt;/span&gt;Document Layer&amp;nbsp;能够和&lt;span style=&quot;color:#24292e&quot;&gt;&lt;span style=&quot;background-color:#ffffff&quot;&gt;所有最新的官方 MongoDB 驱动搭配使用。&lt;/span&gt;&lt;/span&gt;&lt;/p&gt;&lt;p&gt;&lt;span style=&quot;color:#24292e&quot;&gt;&lt;span style=&quot;background-color:#ffffff&quot;&gt;由于 Document Layer 构建在 FoundationDB 之上，因此它同样拥有和&amp;nbsp;FoundationDB 一样的稳定性 —— 因果一致性和强一致性是默认的操作模式。索引也始终会与插入保持一致。由于 FoundationDB 后端自动处理数据分发，因此它也不需要片键(&lt;/span&gt;&lt;/span&gt;&amp;nbsp;Shard keys&lt;span style=&quot;color:#24292e&quot;&gt;&lt;span style=&quot;background-color:#ffffff&quot;&gt;)。&lt;/span&gt;&lt;/span&gt;&lt;span style=&quot;color:#24292e&quot;&gt;&lt;span style=&quot;background-color:#ffffff&quot;&gt;&lt;a data-cke-saved-href=&quot;https://foundationdb.github.io/fdb-document-layer&quot; target=&quot;_blank&quot; href=&quot;https://foundationdb.github.io/fdb-document-layer&quot;&gt;详细信息请查看此文档&lt;/a&gt;。&lt;/span&gt;&lt;/span&gt;&lt;br/&gt;&lt;/p&gt;&lt;p&gt;&lt;span style=&quot;color:#24292e&quot;&gt;&lt;span style=&quot;background-color:#ffffff&quot;&gt;&lt;/span&gt;&lt;/span&gt;FoundationDB Document Layer 的一些特性：&lt;span style=&quot;color:#24292e&quot;&gt;&lt;span style=&quot;background-color:#ffffff&quot;&gt;&lt;/span&gt;&lt;/span&gt;&lt;/p&gt;&lt;ul class=&quot; list-paddingleft-2&quot;&gt;&lt;li&gt;&lt;p&gt;兼容 MongoDB&amp;nbsp;API&lt;/p&gt;&lt;/li&gt;&lt;li&gt;&lt;p&gt;&lt;span style=&quot;color:#484856&quot;&gt;使用 FoundationDB 进行可扩展的文档存储&lt;/span&gt;&lt;/p&gt;&lt;/li&gt;&lt;/ul&gt;&lt;p&gt;&lt;a data-cke-saved-href=&quot;https://www.foundationdb.org/blog/announcing-document-layer/&quot; target=&quot;_blank&quot; href=&quot;https://www.foundationdb.org/blog/announcing-document-layer/&quot;&gt;更多关于 FoundationDB Document Layer 的介绍请点此查看&lt;/a&gt;。&lt;/p&gt;
     * link : https://www.oschina.net/news/102310/announcing-document-layer
     * modify_date : 2018-12-04 05:40:08
     * pubDate : 2018-12-02 08:13:14
     * published : 2018-12-03 16:03:15
     * rss_link : https://www.oschina.net/news/rss
     * rss_published : 2018-12-03 16:03:15
     * rss_title : 开源中国社区最新新闻
     * title : FoundationDB 开源文档数据库模型 Document Layer​​​​​​​
     */

//    private IdBean _id;
    private String guid;
    private String category;
    private String create_date;
    private String description;
    private String link;
    private String modify_date;
    private String pubDate;
    private String published;
    private String rss_link;
    private String rss_published;
    private String rss_title;
    private String title;
    
    public ArticleEntity() {
    }

    @Generated(hash = 2104321691)
    public ArticleEntity(String guid, String category, String create_date, String description, String link, String modify_date, String pubDate, String published, String rss_link, String rss_published, String rss_title, String title) {
        this.guid = guid;
        this.category = category;
        this.create_date = create_date;
        this.description = description;
        this.link = link;
        this.modify_date = modify_date;
        this.pubDate = pubDate;
        this.published = published;
        this.rss_link = rss_link;
        this.rss_published = rss_published;
        this.rss_title = rss_title;
        this.title = title;
    }

//    public IdBean get_id() {
//        return _id;
//    }
//
//    public void set_id(IdBean _id) {
//        this._id = _id;
//    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getModify_date() {
        return modify_date;
    }

    public void setModify_date(String modify_date) {
        this.modify_date = modify_date;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public String getRss_link() {
        return rss_link;
    }

    public void setRss_link(String rss_link) {
        this.rss_link = rss_link;
    }

    public String getRss_published() {
        return rss_published;
    }

    public void setRss_published(String rss_published) {
        this.rss_published = rss_published;
    }

    public String getRss_title() {
        return rss_title;
    }

    public void setRss_title(String rss_title) {
        this.rss_title = rss_title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public static class IdBean {
//        /**
//         * $oid : 5c0347ee57a28ba3d5b55181
//         */
//
//        private String $oid;
//
//        public String get$oid() {
//            return $oid;
//        }
//
//        public void set$oid(String $oid) {
//            this.$oid = $oid;
//        }
//    }
}
