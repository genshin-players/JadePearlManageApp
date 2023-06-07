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

            <div class="row page-titles">
                <ol class="text-center">
                    <button id="prevDay" class="btn btn-info" onclick="prevDay()">上一日</button>
                    <span id="workTime" class="text-warning text" style="font-weight: bolder; font-size: 30px">2023-12-12</span>
                    <button id="nextDay" class="btn btn-info" onclick="nextDay()">下一日</button>
                </ol>
            </div>

            <div class="row">

                <div class="col-xl-3">
                    <div class="card text-white bg-danger" onclick="toDetailPage(this)"
                         data_class="小王班" data_total="100" data_late="10" data_absence="10">
                        <div class="card-header">
                            <a  class="card-title text-white" style="font-weight: bolder;font-size: 25px">小王班  <span>(缺)</span></a>
                            <span class="text-dark" style="font-weight: bolder;font-size: 10px">2023-12-12</span>
                        </div>
                        <div class="card-body mb-0">
                            <span class="text-white" style="font-weight: bolder;font-size: 18px">总人数:</span><span style="font-size: 15px;margin-left: 20px">100人</span><br>
                            <hr>
                            <span class="text-white" style="font-weight: bolder;font-size: 18px">出勤数:</span><span style="font-size: 15px;margin-left: 20px">10人</span><br>
                            <hr>
                            <span class="text-white" style="font-weight: bolder;font-size: 18px">迟到:</span><span style="font-size: 15px;margin-left: 40px">10人</span><br>
                            <hr>
                            <span class="text-white" style="font-weight: bolder;font-size: 18px">缺勤:</span><span style="font-size: 15px;margin-left: 40px">80人</span><br>
                        </div>
                    </div>
                </div>
                <div class="col-xl-3">
                    <div class="card text-white bg-orange">
                        <div class="card-header">
                            <a  class="card-title text-white" style="font-weight: bolder;font-size: 25px">大王班<span>(缺)</span></a>
                            <span class="text-dark" style="font-weight: bolder;font-size: 10px">2023-12-12</span>
                        </div>
                        <div class="card-body mb-0">
                            <span class="text-white" style="font-weight: bolder;font-size: 18px">总人数:</span><span style="font-size: 15px;margin-left: 20px">100人</span><br>
                            <hr>
                            <span class="text-white" style="font-weight: bolder;font-size: 18px">出勤数:</span><span style="font-size: 15px;margin-left: 20px">80人</span><br>
                            <hr>
                            <span class="text-white" style="font-weight: bolder;font-size: 18px">迟到:</span><span style="font-size: 15px;margin-left: 40px">10人</span><br>
                            <hr>
                            <span class="text-white" style="font-weight: bolder;font-size: 18px">缺勤:</span><span style="font-size: 15px;margin-left: 40px">10人</span><br>
                        </div>
                    </div>
                </div>
                <div class="col-xl-3">
                    <div class="card text-white bg-success">
                        <div class="card-header">
                            <a  class="card-title text-white" style="font-weight: bolder;font-size: 25px">老王班<span>(全)</span></a>
                            <span class="text-dark" style="font-weight: bolder;font-size: 10px">2023-12-12</span>
                        </div>
                        <div class="card-body mb-0">
                            <span class="text-white" style="font-weight: bolder;font-size: 18px">总人数:</span><span style="font-size: 15px;margin-left: 20px">100人</span><br>
                            <hr>
                            <span class="text-white" style="font-weight: bolder;font-size: 18px">出勤数:</span><span style="font-size: 15px;margin-left: 20px">100人</span><br>
                            <hr>
                            <span class="text-white" style="font-weight: bolder;font-size: 18px">迟到:</span><span style="font-size: 15px;margin-left: 40px">0人</span><br>
                            <hr>
                            <span class="text-white" style="font-weight: bolder;font-size: 18px">缺勤:</span><span style="font-size: 15px;margin-left: 40px">0人</span><br>
                        </div>
                    </div>
                </div>
                <div class="col-xl-3">
                    <div class="card text-white bg-success">
                        <div class="card-header">
                            <a  class="card-title text-white" style="font-weight: bolder;font-size: 25px">大灯班<span>(全)</span></a>
                            <span class="text-dark" style="font-weight: bolder;font-size: 10px">2023-12-12</span>
                        </div>
                        <div class="card-body mb-0">
                            <span class="text-white" style="font-weight: bolder;font-size: 18px">总人数:</span><span style="font-size: 15px;margin-left: 20px">100人</span><br>
                            <hr>
                            <span class="text-white" style="font-weight: bolder;font-size: 18px">出勤数:</span><span style="font-size: 15px;margin-left: 20px">100人</span><br>
                            <hr>
                            <span class="text-white" style="font-weight: bolder;font-size: 18px">迟到:</span><span style="font-size: 15px;margin-left: 40px">0人</span><br>
                            <hr>
                            <span class="text-white" style="font-weight: bolder;font-size: 18px">缺勤:</span><span style="font-size: 15px;margin-left: 40px">0人</span><br>
                        </div>
                    </div>
                </div>
                <div class="col-xl-3">
                    <div class="card text-white bg-success">
                        <div class="card-header">
                            <a  class="card-title text-white" style="font-weight: bolder;font-size: 25px">老灯班（爆金币咯）<span>(全)</span></a>
                            <span class="text-dark" style="font-weight: bolder;font-size: 10px">2023-12-12</span>
                        </div>
                        <div class="card-body mb-0">
                            <span class="text-white" style="font-weight: bolder;font-size: 18px">总人数:</span><span style="font-size: 15px;margin-left: 20px">100人</span><br>
                            <hr>
                            <span class="text-white" style="font-weight: bolder;font-size: 18px">出勤数:</span><span style="font-size: 15px;margin-left: 20px">100人</span><br>
                            <hr>
                            <span class="text-white" style="font-weight: bolder;font-size: 18px">迟到:</span><span style="font-size: 15px;margin-left: 40px">0人</span><br>
                            <hr>
                            <span class="text-white" style="font-weight: bolder;font-size: 18px">缺勤:</span><span style="font-size: 15px;margin-left: 40px">0人</span><br>
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


//卡片点击时间 去详情页面a
    function toDetailPage(t) {

        var className=t.getAttribute("data_class");
        var total=t.getAttribute("data_total");
        var late=t.getAttribute("data_late");
        var absence=t.getAttribute("data_absence");

        var dateNow=pageDate.getFullYear()+"-"+(pageDate.getUTCMonth()+1)+"-"+pageDate.getDate();

        window.location.href="http://localhost:8080/toStuAttendanceDetail?className="+className+"&total="+total+"&late="+late+"&absence="+absence+"&date="+dateNow;
    }


</script>
</body>
</html>