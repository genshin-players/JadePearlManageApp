<#include "../header.ftlh">
<#--社员 之  卡片点进去的详情页面-->



    <!--**********************************
            Sidebar end
        ***********************************-->

    <!--**********************************
            Content body start
        ***********************************-->
    <div class="content-body">
        <div class="container-fluid">


            <!-- row -->


            <div class="row">



                <div class="col-12">
                    <div class="card" style="box-shadow: 10px 10px 20px 10px rgba(0, 0, 255, .2);opacity: 0.8 ">
                        <div class="card-header bg-light">

                            <#--<h4 class="card-title"><span style="font-weight: bolder;font-size: 20px">${memName}${date?string("yyyy-MM-dd")}</span>出勤详情</h4>
                            <button class="btn btn-info" onclick="javascript:window.location.href='http://localhost:8080/toEditStudentAttendance';">添加出勤记录</button>-->

                            <div class="row align-items-center" style="width: 100%">
                                <div class="col-md-4" >
                                    <div class="review-bx">
                                        <img class="me-3" src="https://ts1.cn.mm.bing.net/th/id/R-C.10a3a71ab80c436107328a8d81e32033?rik=n0pyglnxrPqVUg&riu=http%3a%2f%2fpic33.photophoto.cn%2f20141101%2f0005018375784908_b.jpg&ehk=Tz7OfUGkjvjH7%2fEymvfRuK4k54nv8kGklSznwlli%2bB0%3d&risl=&pid=ImgRaw&r=0" alt="">
                                        <div>
                                            <span class="text-primary fs-16">#EMP-00025</span>
                                            <input type="hidden" name="memName" value="${memName}">
                                            <h4 class="mt-1 fs-20 font-w600"><a class="text-black" href="guest-detail.html">${memName}(社员)</a></h4>
                                            <span class="fs-12" style="font-weight: bolder;color: dimgray">男--18岁--小王班</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <ul class="star-review mb-2">
                                        <li><span class="text" style="font-weight: bolder;color: #0b3b97">班主任--暮光星灵</span></li> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <li><span class="text" style="font-weight: bolder;color: #0b3b97">联系方式--18545647895</span></li> &nbsp;&nbsp;&nbsp;&nbsp;
                                        <li><span class="text" style="font-weight: bolder;color: #0b3b97">身份信息--123456789465789465789</span></li>

                                    </ul>

                                </div>
                                <div class="col-md-2">
                                    <button class="btn btn-primary" onclick="toAssignOneWork()">安排工作</button>
                                </div>
                            </div>


                        </div>
                        <div class="card-body">


                            <div class="table-responsive">
                                <table id="example4" class="display" style="min-width: 845px">
                                    <thead>
                                    <tr>
                                        <th>编号</th>
                                        <th>姓名</th>
                                        <th>工作内容</th>
                                        <th>工作日期</th>
                                        <th>排班人</th>
                                        <th>工作进度</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>01</td>
                                        <td>${memName}</td>
                                        <td>站岗</td>
                                        <td>2023-06-05</td>
                                        <td>暮光星灵</td>
                                        <td>
                                            <span class="badge light badge-success">
														<i class="fa fa-circle text-success me-1"></i>
														已完成
													</span>
                                        </td>
                                        <#---->
                                        <td>
                                            <div class="dropdown ms-auto text-end">
                                                <div class="btn-link" data-bs-toggle="dropdown">
                                                    <svg width="24px" height="24px" viewbox="0 0 24 24" version="1.1"><g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd"><rect x="0" y="0" width="24" height="24"></rect><circle fill="#000000" cx="5" cy="12" r="2"></circle><circle fill="#000000" cx="12" cy="12" r="2"></circle><circle fill="#000000" cx="19" cy="12" r="2"></circle></g></svg>
                                                </div>
                                                <div class="dropdown-menu dropdown-menu-end">
                                                    <a class="dropdown-item" href="http://localhost:8080/toEditStudentAttendance">修改记录</a>
                                                    <a class="dropdown-item" href="#">删除记录</a>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>02</td>
                                        <td>${memName}</td>
                                        <td>查班</td>
                                        <td>2023-06-05</td>
                                        <td>暮光星灵</td>
                                        <td>
                                            <span class="badge light badge-warning">
														<i class="fa fa-circle text-warning me-1"></i>
														未完成
													</span>
                                        </td>
                                        <#---->
                                        <td>
                                            <div class="dropdown ms-auto text-end">
                                                <div class="btn-link" data-bs-toggle="dropdown">
                                                    <svg width="24px" height="24px" viewbox="0 0 24 24" version="1.1"><g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd"><rect x="0" y="0" width="24" height="24"></rect><circle fill="#000000" cx="5" cy="12" r="2"></circle><circle fill="#000000" cx="12" cy="12" r="2"></circle><circle fill="#000000" cx="19" cy="12" r="2"></circle></g></svg>
                                                </div>
                                                <div class="dropdown-menu dropdown-menu-end">
                                                    <a class="dropdown-item" href="http://localhost:8080/toEditStudentAttendance">修改记录</a>
                                                    <a class="dropdown-item" href="#">删除记录</a>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>03</td>
                                        <td>${memName}</td>
                                        <td>举办活动</td>
                                        <td>2023-06-05</td>
                                        <td>暮光星灵</td>
                                        <td>
                                            <span class="badge light badge-warning">
														<i class="fa fa-circle text-warning me-1"></i>
														未完成
													</span>
                                        </td>
                                        <#---->
                                        <td>
                                            <div class="dropdown ms-auto text-end">
                                                <div class="btn-link" data-bs-toggle="dropdown">
                                                    <svg width="24px" height="24px" viewbox="0 0 24 24" version="1.1"><g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd"><rect x="0" y="0" width="24" height="24"></rect><circle fill="#000000" cx="5" cy="12" r="2"></circle><circle fill="#000000" cx="12" cy="12" r="2"></circle><circle fill="#000000" cx="19" cy="12" r="2"></circle></g></svg>
                                                </div>
                                                <div class="dropdown-menu dropdown-menu-end">
                                                    <a class="dropdown-item" href="http://localhost:8080/toEditStudentAttendance">修改记录</a>
                                                    <a class="dropdown-item" href="#">删除记录</a>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>



                                    </tbody>
                                </table>
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
<script src="js/Chart.bundle.min.js"></script>
<!-- Apex Chart -->
<script src="js/apexchart.js"></script>

<!-- Datatable -->
<script src="js/jquery.dataTables.min.js"></script>
<script src="js/datatables.init.js"></script>

<script src="js/jquery.nice-select.min.js"></script>

<script src="js/custom.min.js"></script>
<script src="js/deznav-init.js"></script>
<script src="js/demo.js"></script>
<script src="js/styleSwitcher.js"></script>

<script>
    function toAssignOneWork() {
        var memName=$("[name=memName]").val();
        window.location.href="http://localhost:8080/toAssignOneWork?memName="+memName;

    }
</script>
</body>
</html>