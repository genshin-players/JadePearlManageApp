<#include "../header.ftlh"/>


<#--班级出勤页面-->


<!--**********************************
    Sidebar end
***********************************-->

<!--**********************************
    Content body start
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
                <span id="workTime" class="text-warning text" style="font-weight: bolder; font-size: 30px">2023-12-12</span>
                <button id="nextDay" class="btn btn-info" onclick="nextDay()">下一日</button>
            </ol>
            <hr style="height: 2px">
        </div>

        <div class="row">
            <#---->

            <div class="col-xl-3">
                <div class="card text-white bg-danger" onclick="toDetailPage(this)"
                     data_name="亚托克斯" data_total="100" data_late="10" data_absence="10">
                    <div class="card-header">
                        <a  class="card-title text-white" style="font-weight: bolder;font-size: 25px">亚托克斯  <span>(未完成)</span></a>
                        <span class="text-dark card_date" style="font-weight: bolder;font-size: 10px">2023-12-12</span>
                    </div>
                    <div class="card-body mb-0">
                        <span class="text-white" style="font-weight: bolder;font-size: 18px">工作:</span><span style="font-size: 15px;margin-left: 40px">做佐伊小姐的狗（佐伊改）</span><br>
                        <hr>
                        <span class="text-white" style="font-weight: bolder;font-size: 18px">所在班:</span><span style="font-size: 15px;margin-left: 20px">小王班</span><br>
                        <hr>
                        <span class="text-white" style="font-weight: bolder;font-size: 18px">进度:</span><span style="font-size: 15px;margin-left: 40px">未完成</span><br>
                    </div>
                </div>
            </div>
            <div class="col-xl-3">
                <div class="card text-white bg-danger" onclick="toDetailPage(this)"
                     data_name="暮光星灵" data_total="100" data_late="10" data_absence="10">
                    <div class="card-header">
                        <a  class="card-title text-white" style="font-weight: bolder;font-size: 25px">暮光星灵  <span>(未完成)</span></a>
                        <span class="text-dark card_date" style="font-weight: bolder;font-size: 10px">2023-12-12</span>
                    </div>
                    <div class="card-body mb-0">
                        <span class="text-white" style="font-weight: bolder;font-size: 18px">工作:</span><span style="font-size: 15px;margin-left: 40px">调教亚托克斯</span><br>
                        <hr>
                        <span class="text-white" style="font-weight: bolder;font-size: 18px">所在班:</span><span style="font-size: 15px;margin-left: 20px">小王班</span><br>
                        <hr>
                        <span class="text-white" style="font-weight: bolder;font-size: 18px">负责班级:</span><span style="font-size: 15px;margin-left: 20px">小王班/大王班/老王班</span><br>
                        <hr>
                        <span class="text-white" style="font-weight: bolder;font-size: 18px">进度:</span><span style="font-size: 15px;margin-left: 40px">未完成</span><br>
                    </div>
                </div>
            </div>
            <div class="col-xl-3">
                <div class="card text-white bg-success" onclick="toDetailPage(this)"
                     data_name="佛耶戈" data_total="100" data_late="10" data_absence="10">
                    <div class="card-header">
                        <a  class="card-title text-white" style="font-weight: bolder;font-size: 25px">佛耶戈  <span>(完成)</span></a>
                        <span class="text-dark card_date" style="font-weight: bolder;font-size: 10px">2023-12-12</span>
                    </div>
                    <div class="card-body mb-0">
                        <span class="text-white" style="font-weight: bolder;font-size: 18px">工作:</span><span style="font-size: 15px;margin-left: 40px">被网易云波比抛弃</span><br>
                        <hr>
                        <span class="text-white" style="font-weight: bolder;font-size: 18px">所在班:</span><span style="font-size: 15px;margin-left: 20px">小王班</span><br>
                        <hr>
                        <span class="text-white" style="font-weight: bolder;font-size: 18px">负责班级:</span><span style="font-size: 15px;margin-left: 20px">小灯班/大灯班/老灯班</span><br>
                        <hr>
                        <span class="text-white" style="font-weight: bolder;font-size: 18px">进度:</span><span style="font-size: 15px;margin-left: 40px">完成</span><br>
                    </div>
                </div>
            </div>
            <div class="col-xl-3">
                <div class="card text-white bg-success" onclick="toDetailPage(this)"
                     data_name="莫菲特" data_total="100" data_late="10" data_absence="10">
                    <div class="card-header">
                        <a  class="card-title text-white" style="font-weight: bolder;font-size: 25px">莫菲特  <span>(完成)</span></a>
                        <span class="text-dark card_date" style="font-weight: bolder;font-size: 10px">2023-12-12</span>
                    </div>
                    <div class="card-body mb-0">
                        <span class="text-white" style="font-weight: bolder;font-size: 18px">工作:</span><span style="font-size: 15px;margin-left: 40px">卸载脑子</span><br>
                        <hr>
                        <span class="text-white" style="font-weight: bolder;font-size: 18px">所在班:</span><span style="font-size: 15px;margin-left: 20px">小王班</span><br>
                        <hr>
                        <span class="text-white" style="font-weight: bolder;font-size: 18px">进度:</span><span style="font-size: 15px;margin-left: 40px">完成</span><br>
                    </div>
                </div>
            </div>
            <div class="col-xl-3">
                <div class="card text-white bg-success" onclick="toDetailPage(this)"
                     data_name="维鲁斯" data_total="100" data_late="10" data_absence="10">
                    <div class="card-header">
                        <a  class="card-title text-white" style="font-weight: bolder;font-size: 25px">维鲁斯  <span>(完成)</span></a>
                        <span class="text-dark card_date" style="font-weight: bolder;font-size: 10px">2023-12-12</span>
                    </div>
                    <div class="card-body mb-0">
                        <span class="text-white" style="font-weight: bolder;font-size: 18px">工作:</span><span style="font-size: 15px;margin-left: 40px">找俩gay合体</span><br>
                        <hr>
                        <span class="text-white" style="font-weight: bolder;font-size: 18px">所在班:</span><span style="font-size: 15px;margin-left: 20px">小王班</span><br>
                        <hr>
                        <span class="text-white" style="font-weight: bolder;font-size: 18px">进度:</span><span style="font-size: 15px;margin-left: 40px">完成</span><br>
                    </div>
                </div>
            </div>


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
        $("#nextDay").css("display","none");

        $(".card_date").html(date.getFullYear()+"-"+(date.getUTCMonth()+1)+"-"+date.getDate());
    });

    function prevDay() {
        var date=pageDate;
        date.setDate(date.getDate()-1);
        $("#workTime").html(date.getFullYear()+"-"+(date.getUTCMonth()+1)+"-"+date.getDate());
        pageDate=date;
        var date1=new Date();


        if(date.getMonth()==date1.getMonth()&&date.getDate()==date1.getDate()){
            $("#nextDay").css("display","none");
        }else{
            $("#nextDay").css("display","inline");
        }
    }

    function nextDay() {
        var date=pageDate;
        date.setDate(date.getDate()+1);
        $("#workTime").html(date.getFullYear()+"-"+(date.getUTCMonth()+1)+"-"+date.getDate());
        pageDate=date;
        var date1=new Date();
        if(date.getMonth()==date1.getMonth()&&date.getDate()==date1.getDate()){
            $("#nextDay").css("display","none");
        }else {
            $("#nextDay").css("display","inline");
        }
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
