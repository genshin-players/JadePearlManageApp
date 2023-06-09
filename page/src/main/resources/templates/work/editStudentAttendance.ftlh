<#include "../header.ftlh"/>


<#--班级出勤编辑页面-->
<link rel="stylesheet" href="/css/select2.min.css">
<link href="/css/nice-select.css" rel="stylesheet">
<link href="/css/style.css" rel="stylesheet">


<!-- Daterange picker -->
<link href="/css/daterangepicker.css" rel="stylesheet">
<!-- Clockpicker -->
<link href="/css/bootstrap-clockpicker.min.css" rel="stylesheet">
<!-- asColorpicker -->
<link href="/css/asColorPicker.min.css" rel="stylesheet">
<!-- Material color picker -->
<link href="/css/bootstrap-material-datetimepicker.css" rel="stylesheet">

<!-- Pick date -->
<link rel="stylesheet" href="/css/default.css">
<link rel="stylesheet" href="/css/default.date.css">
<link href="/css/icon.css" rel="stylesheet">
<!-- Custom Stylesheet -->
<link href="/css/nice-select.css" rel="stylesheet">
<link href="/css/style.css" rel="stylesheet">




<!--**********************************
           Content body start
       ***********************************-->
<div class="content-body">
    <div class="container-fluid">
        <div class="row">
            <div class="col-xl-2"></div>
            <div class="col-xl-8">
                <div class="card bg-light bg" style="box-shadow: 10px 10px 20px 10px rgba(0, 0, 255, .2);opacity: 0.8 ">
                    <div class="card-header">
                        <span class="card-title text-center text-primary" style="font-weight: bolder;font-size: 25px">编辑学生出勤</span>
                    </div>
                    <div class="card-body">

                        <div class="row">
                            <div class="col-lg-2">
                                <span class="text-white fw-bolder" style="font-size: 18px">选择学生:</span>
                            </div>
                            <div class="col-lg-4">
                                <select class="single-select-placeholder js-states">
                                    <option value="0">请选择学生</option>
                                    <option value="AL">亚托克斯</option>
                                    <option value="WY">墨菲特</option>
                                    <option value="WY">诺克萨斯之手</option>
                                </select>
                            </div>
                            <div class="col-lg-4">

                            </div>
                            <br>
                            <hr style="margin-top: 10px;background-color: white">
                        </div>

                        <div class="row">
                            <div class="col-lg-2">
                                <span class="text-white fw-bolder" style="font-size: 18px">出勤状态:</span>
                            </div>
                            <div class="col-lg-4">
                                <select class="single-select-placeholder js-states">
                                    <option value="0">请选择出勤状态</option>
                                    <option value="AL">出勤</option>
                                    <option value="WY">迟到</option>
                                    <option value="WY">缺勤</option>
                                </select>
                            </div>
                            <div class="col-lg-4">

                            </div>
                            <br>
                            <hr style="margin-top: 10px;background-color: white">

                            <div class="row">
                                <div class="col-lg-2">
                                    <span class="text-white fw-bolder" style="font-size: 18px">日期:</span>
                                </div>
                                <div class="col-lg-4">
                                    <input type="text" class="form-control" placeholder="选择日期" id="mdate" style="height: 35px;margin-left: 10px">
                                </div>
                                <div class="col-lg-4">

                                </div>
                                <br>
                                <hr style="margin-top: 10px;background-color: white">
                                <div class="row">
                                    <div class="col-lg-4">

                                    </div>
                                    <div class="col-lg-4" align="center">
                                        <button class="btn btn-outline-secondary">提交</button>
                                    </div>


                                    </div>
                                    <br>

                        </div>

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
<script src="/js/global.min.js"></script>
<script src="/js/jquery.nice-select.min.js"></script>
<script src="/js/select2.full.min.js"></script>
<script src="/js/select2-init.js"></script>
<script src="/js/custom.min.js"></script>
<script src="/js/deznav-init.js"></script>
<script src="/js/demo.js"></script>
<script src="/js/styleSwitcher.js"></script>


<!--**********************************
        Scripts
    ***********************************-->
<!-- Required vendors -->
<script src="static/js/global.min.js"></script>
<script src="static/js/bootstrap-select.min.js"></script>
<script src="static/js/Chart.bundle.min.js"></script>
<!-- Apex Chart -->
<script src="static/js/apexchart.js"></script>



<!-- Daterangepicker -->
<!-- momment js is must -->
<script src="/js/moment.min.js"></script>
<script src="/js/daterangepicker.js"></script>
<!-- clockpicker -->
<script src="/js/bootstrap-clockpicker.min.js"></script>
<!-- asColorPicker -->
<script src="/js/jquery-asColor.min.js"></script>
<script src="/js/jquery-asGradient.min.js"></script>
<script src="/js/jquery-asColorPicker.min.js"></script>
<!-- Material color picker -->
<script src="/js/bootstrap-material-datetimepicker.js"></script>
<!-- pickdate -->
<script src="/js/picker.js"></script>
<script src="/js/picker.time.js"></script>
<script src="/js/picker.date.js"></script>

<!-- Daterangepicker -->
<script src="/js/bs-daterange-picker-init.js"></script>
<!-- Clockpicker init -->
<script src="/js/clock-picker-init.js"></script>
<!-- asColorPicker init -->
<script src="/js/jquery-asColorPicker.init.js"></script>
<!-- Material color picker init -->
<script src="/js/material-date-picker-init.js"></script>
<!-- Pickdate -->
<script src="/js/pickadate-init.js"></script>

<script src="/js/jquery.nice-select.min.js"></script>

<script src="/js/custom.min.js"></script>
<script src="/js/deznav-init.js"></script>
<script src="/js/demo.js"></script>
<script src="/js/styleSwitcher.js"></script>
</body>
</html>