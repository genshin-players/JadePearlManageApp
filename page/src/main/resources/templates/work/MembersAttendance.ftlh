<#include "../header.ftlh"/>


<#--班级出勤页面-->


<!--**********************************
    Sidebar end
***********************************-->

<!--**********************************
    Content body start
***********************************-->
<style>
    .card:hover{
        cursor: pointer;
        transform: scale3d(1.03,1.03,1);
    }
</style>
<div class="content-body">
    <div class="container-fluid">

        <div class="row page-titles header-panel">
            <ol class="text-center">
                <button id="prevDay" class="btn btn-info" onclick="prevDay()">上一日</button>
                <span id="workTime" class="text-warning text" style="font-weight: bolder; font-size: 30px">${pageDate}</span>
                <button id="nextDay" class="btn btn-info" onclick="nextDay()">下一日</button>
            </ol>
            <hr style="height: 2px">
        </div>

        <div class="row">
            <#---->


           <#if resultVO.data?size!=0>
                <#list resultVO.data as vo>
                    <div class="col-xl-3">
                        <div class="card text-white bg-danger" onclick="toDetailPage(this)"
                             data_name="亚托克斯" data_total="100" data_late="10" data_absence="10">
                            <div class="card-header">
                                <#assign json=vo.member.identityInfo?eval/>
                                <a  class="card-title text-white" style="font-weight: bolder;font-size: 25px">${json.realname}  <span><#if vo.schedules.status==0>(未完成)<#elseif vo.schedules.status==1>(已完成)</#if>
                                    <br>
                                <#assign json=vo.createUser.identityInfo?eval/>
                                <span class="text-dark card_date" style="font-weight: bolder;font-size: 10px">${vo.schedules.createTime?string('yyyy-MM-dd')} ${vo.createUser.identityInfo}  ${json.realname}创建</span>
                                    </span></a>

                            </div>
                            <div class="card-body mb-0">
                                <span class="text-white" style="font-weight: bolder;font-size: 18px">工作:</span><span style="font-size: 15px;margin-left: 40px">${vo.schedulesType.name}</span><br>
                                <hr>
                                <span class="text-white" style="font-weight: bolder;font-size: 18px">所在班:</span><span style="font-size: 15px;margin-left: 20px">${vo.classes.name}</span><br>
                                <hr>
                                <span class="text-white" style="font-weight: bolder;font-size: 18px">进度:</span><span style="font-size: 15px;margin-left: 40px"><#if vo.schedules.status==0>未完成<#elseif vo.schedules.status==1>已完成</#if></span><br>
                            </div>
                        </div>
                    </div>
                </#list>

                <#else >
                    <div class="row">
                        <div class="col-lg-12" align="center">
                            <span class="text" style="color:red;font-weight: bolder;font-size: 30px" >无记录</span>
                        </div>
                    </div>
            </#if>





        </div>
    </div>
</div>
<!--**********************************
    Content body end
***********************************-->


<!--**********************************
    Footer start
***********************************-->
<div class="footer">
    <div class="copyright">
        <p>Copyright &copy; 2021.Company name All rights reserved.<a target="_blank" href="https://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></p>
    </div>
</div>
<!--**********************************
    Footer end
***********************************-->

<!--**********************************
   Support ticket button start
***********************************-->

<!--**********************************
   Support ticket button end
***********************************-->


</div>
<!--**********************************
    Main wrapper end
***********************************-->

<!--**********************************
    Scripts
***********************************-->
<!-- Required vendors -->
<script src="js/global.min.js"></script>
<script src="js/jquery.nice-select.min.js"></script>
<script src="js/custom.min.js"></script>
<script src="js/deznav-init.js"></script>
<script src="js/demo.js"></script>
<script src="js/styleSwitcher.js"></script>

<script>
    //custom select box
    var pageDate;

    $(function(){
        var date = new Date();
        $("#workTime").html(date.getFullYear()+"-"+(date.getUTCMonth()+1)+"-"+date.getDate());
        pageDate=date;


        $(".card_date").html(date.getFullYear()+"-"+(date.getUTCMonth()+1)+"-"+date.getDate());
    });

    function prevDay() {
        var date=pageDate;
        date.setDate(date.getDate()-1);
        $("#workTime").html(date.getFullYear()+"-"+(date.getUTCMonth()+1)+"-"+date.getDate());
        pageDate=date;
        var date1=new Date();



    }

    function nextDay() {
        var date=pageDate;
        date.setDate(date.getDate()+1);
        $("#workTime").html(date.getFullYear()+"-"+(date.getUTCMonth()+1)+"-"+date.getDate());
        pageDate=date;
        var date1=new Date();

    }


    //卡片点击时间 去详情页面
    function toDetailPage(t) {

        var memName=t.getAttribute("data_name");

        var dateNow=pageDate.getFullYear()+"-"+(pageDate.getUTCMonth()+1)+"-"+pageDate.getDate();

        window.location.href="/toMemAttendanceDetail?memName="+memName+"&date="+dateNow;
    }


</script>
</body>
</html>