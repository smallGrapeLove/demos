<%--
  Created by IntelliJ IDEA.
  User: huan.xu
  Date: 2019/2/13
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>demo_juicer</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/jQuery/jquery-1.11.3.min.js"></script>
    <script type='text/javascript' src='${pageContext.request.contextPath}/script/juicer/juicer-min.js'></script>

    <style type="text/css">
        table.gridtable {
            font-family: verdana, arial, sans-serif;
            font-size: 11px;
            color: #333333;
            border-width: 1px;
            border-color: #666666;
            border-collapse: collapse;
        }

        table.gridtable th {
            border-width: 1px;
            padding: 8px;
            border-style: solid;
            border-color: #666666;
            background-color: #dedede;
        }

        table.gridtable td {
            border-width: 1px;
            padding: 8px;
            border-style: solid;
            border-color: #666666;
            background-color: #ffffff;
            text-align: center;
        }
    </style>

    <script type="text/javascript">
        juicer.set({
            'tag::operationOpen': '{@',
            'tag::operationClose': '}',
            'tag::interpolateOpen': '{{',
            'tag::interpolateClose': '}}',
            'tag::noneencodeOpen': '{{{',
            'tag::noneencodeClose': '}}}',
            'tag::commentOpen': '{#',
            'tag::commentClose': '}'
        });

        var _index = 1;

        /**
         * add button
         */
        function addTr() {
            var data = {
                index: _index,
                text: 'text' + _index
            };
            var trTemplage = document.getElementById('trTemplage').innerHTML;
            var html = juicer(trTemplage, data);
            $("#tbody").append(html);
            _index++;
        }

        /**
         * del button
         */
        function delTr() {
            var checkedArr = $("input:checkbox[name='checkbox']:checked");
            if (checkedArr.length > 0) {
                $.each(checkedArr, function (i, v) {
                    $(v).parent().parent().remove();
                })

            } else {
                alert("please select del data");
            }
        }

        /**
         * select all or clear all
         * @param flag
         */
        function allCheck(flag) {
            var checkboxArr = $("input:checkbox[name='checkbox']");
            $.each(checkboxArr, function (i, v) {
                if (flag) {
                    //select all
                    $(v).prop("checked", true);
                } else {
                    //clear all
                    $(v).prop("checked", false);
                }
            })
        }

    </script>
</head>
<body>
<input type="button" value="add" onclick="addTr()">
<input type="button" value="del" onclick="delTr()">

<div style="padding-top: 3px;">
    <table class="gridtable">
        <thead>
        <tr>
            <th style="width: 30px;">
                <input type="checkbox" name="allCheckbox" onclick="allCheck(this.checked)">
            </th>
            <th style="width: 30px;">编号</th>
            <th style="width: 200px;">内容</th>
        </tr>
        </thead>
        <tbody id="tbody">

        </tbody>
    </table>
</div>
</body>

<script type="text/template" id="trTemplage">
    <tr>
        <td>
            <input type="checkbox" name="checkbox">
        </td>
        <td>{{index}}</td>
        <td>{{text}}</td>
    </tr>
</script>
</html>
