package com.ucmed.hnust.controller.enterpriseWeChat;

/**
 * Created by ZY-LJ-1446 on 2018/4/18.
 */
public class PublicVariable {
    //企业ID
    public static final String corpid="wwe1a4da7b2beb9def";
    //饭桶应用ID
    public static final String fantongid="1000003";
    //检验单应用ID
    public static final String jydid="1000005";


    //通讯录secret
    public static final String txlsecret="tTUn2hxYPm1YZedJNvFuk94Vhu-ujuVqMwbLTtdTGSI";
    //个人测试应用secret
    public static final String gryysecret="1-x-EfvW1KutASNjrawDb4x0ZExIyR-mCbBoZZOZ4AA";
    //饭桶secret
    public  static final String fantongsecret="-w2Yn3vqrYYGV__epx0hwINWdTvFFy9f8vsLiVlGwsg";
    //检验单secret
    public static final String jydsecret="HLXolOhDh_a00DtknlyXclO3wPMAcNS51lGpkRiez38";


    //获取access_token
    public static final String tokenuri = "https://qyapi.weixin.qq.com/cgi-bin/gettoken";


    //通讯录管理创建成员
    public static final String creatememberuri = "https://qyapi.weixin.qq.com/cgi-bin/user/create?access_token=";
    //读取成员
    public static final String dqcy="https://qyapi.weixin.qq.com/cgi-bin/user/get";
    //上传临时素材
    public static final String uploadrui="https://qyapi.weixin.qq.com/cgi-bin/media/upload?access_token=";
    //通讯录异步批量全量覆盖部门
    public static final String deptall="https://qyapi.weixin.qq.com/cgi-bin/batch/replaceparty?access_token=";
    //通讯录异步批量获取异步任务结果
    public static final String hqybrwjg="https://qyapi.weixin.qq.com/cgi-bin/batch/getresult";
    //根据code获取成员信息
    public static final String hqcyxxbycode="https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo";
    //使用user_ticket获取成员详情
    public static final String hqcyxqbyticket="https://qyapi.weixin.qq.com/cgi-bin/user/getuserdetail?access_token=";
    //发送消息
    public static final String fsxx="https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=";
    //获取jsapi_ticket
    public static final String jsapiticket="https://qyapi.weixin.qq.com/cgi-bin/get_jsapi_ticket";

    //设置通讯录接收事件服务器sToken(若在后台重新填写stoken或重新随机生成,此处也要对应修改)
    public static final String stoken="Q6M7bII7VAtezRUuVROzcKrMe";
    //设置通讯录接收事件服务器验证sEncodingAESKey(若在后台重新填写sEncodingAESKey或重新随机生成,此处也要对应修改)
    public static final String sencodingaeskey="pBjTFRYmXPb0nR4ysXqIeMKcuBkx1rAFkEdBdGgIXIK";
    //通讯录接收事件服务器验证  GET
    public static final String szjssjfwq="http://test.lj.ucmed.cn/jssjfwq/yzurl/";
    //通讯录接收消息服务器  POST
    public static final String jsxxfwq="http://test.lj.ucmed.cn/jssjfwq/yzurl/";

    //设置饭桶接收事件服务器sToken(若在后台重新填写stoken或重新随机生成,此处也要对应修改)
    public static final String fantongstoken="alKuWiUY4QqG9rhQlD34P74YXcuvcWR";
    //设置饭桶接收事件服务器验证sEncodingAESKey(若在后台重新填写sEncodingAESKey或重新随机生成,此处也要对应修改)
    public static final String fantongsencodingaeskey="cL36lfa6GshsM7rHMDicCIkD4BJyxQQwhjOIV84IWGa";
    //饭桶接收事件服务器验证  GET
    public static final String fantongszjssjfwq="http://test.lj.ucmed.cn/fantong/yzurl/";
    //饭桶接收消息服务器  POST
    public static final String fantongjsxxfwq="http://test.lj.ucmed.cn/fantong/yzurl/";

    //临时文件上传路径(仅测试使用)
    public static final String fileuploaduri="D:/Tomcat 7.0/webapps/FileUpload/";
}
