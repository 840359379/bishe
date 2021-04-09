layui.use(['table',"element"], function(){
    var table = layui.table;
    var element = layui.element;

    table.render({
        elem: '#demo'
        ,url: '/blog/invitation/invitations' //数据接口
        ,page: true //开启分页
        ,limit: 10
        ,cols: [[ //表头
            {field: 'number', title: '动态编号', sort: true, fixed: 'left',event:1}
            ,{field: 'account', title: '用户ID'}
            ,{field: 'name', title: '姓名', sort: true}
            ,{field: 'time', title: '发表时间', sort: true}
            ,{field: 'title', title: '标题', sort: true}
            ,{field: 'text', title: '路径',width:500, sort: true}
            ,{field: 'option', title: '操作' ,toolbar:'#barDemo',width: 70}
        ]]
    });

    table.render({
        elem: '#whimsy'
        ,url: '/blog/backstage/look/whimsy' //数据接口
        ,page: true //开启分页
        ,limit: 10
        ,cols: [[ //表头
            {field: 'id', title: '随想编号', sort: true, fixed: 'left',event:2}
            ,{field: 'account', title: '用户ID'}
            ,{field: 'series', title: '一系列的贴子',sort: true,}
            ,{field: 'startTime', title: '发表时间', sort: true}
            ,{field: 'title', title: '标题', sort: true}
            ,{field: 'obtain', title: '硬币数', sort: true}
            ,{field: 'option', title: '操作' ,toolbar:'#barDemo',width: 70}
        ]]
    });

    table.render({
        elem: '#user'
        ,url: '/blog/backstage/look/users' //数据接口
        ,page: true //开启分页
        ,limit: 10
        ,cols: [[ //表头
            {field: 'account', title: '用户ID', sort: true, fixed: 'left',event:5}
            ,{field: 'name', title: '姓名', sort: true}
            ,{field: 'gender', title: '性别',sort: true,}
            ,{field: 'birthday', title: '生日', sort: true}
            ,{field: 'mailbox', title: '邮箱', sort: true}
            ,{field: 'personality', title: '个性签名', sort: true}
            ,{field: 'portrait', title: '头像', sort: true}
            ,{field: 'coin', title: '随想硬币', sort: true}
            ,{field: 'option', title: '操作' ,toolbar:'#barDemo',width: 70}
        ]]
    });

    table.render({
        elem: '#uploads'
        ,url: '/blog/backstage/look/upload' //数据接口
        ,page: true //开启分页
        ,limit: 10
        ,cols: [[ //表头
            {field: 'id', title: '上传编号', sort: true, fixed: 'left',event:4}
            ,{field: 'account', title: '用户ID'}
            ,{field: 'race', title: '文件类型',sort: true,}
            ,{field: 'name', title: '文件名', sort: true}
            ,{field: 'route', title: '路径', sort: true}
            ,{field: 'startTime', title: '上传时间', sort: true}
            ,{field: 'option', title: '操作' ,toolbar:'#barDemo',width: 70}
        ]]
    });

    table.render({
        elem: '#content'
        ,url: '/blog/backstage/look/content' //数据接口
        ,page: true //开启分页
        ,limit: 20
        ,cols: [[ //表头
            {field: 'id', title: '评论编号', sort: true, fixed: 'left',event:3}
            ,{field: 'number', title: '所属动态'}
            ,{field: 'account', title: '评论者',sort: true,}
            ,{field: 'name', title: '文件名', sort: true}
            ,{field: 'content', title: '内容', sort: true}
            ,{field: 'startTime', title: '评论时间', sort: true}
            ,{field: 'option', title: '操作' ,toolbar:'#barDemo',width: 70}
        ]]
    });

    // 监听行工具蓝时间
    table.on('tool(test)',function(obj){
        switch(obj.event){
            case 'del':
                layer.confirm('您确定要删除吗?', function (index) {
                    let event =  obj.tr.get(0).firstElementChild.getAttribute("lay-event")
                    let data = {};
                    switch (event){
                        case '1':
                            data = {surface:obj.data.number,event:event};
                            break;
                        case '2':
                        case '3':
                        case '4':
                            data = {surface:obj.data.id,event:event};
                            break;
                        default:
                            data = {surface:obj.data.account,event:event};
                            break;
                    }
                    $.ajax({
                        data:data,
                        url:"http://127.0.0.1:8080/blog/backstage/delete/data",
                        dataType:"JSON",
                        type:"POST",
                        success:function (data){
                            if(data.code){
                                location.reload();
                            }else {
                                layui.msg("操作失败");
                            }
                        },error:function (){
                            layui.msg("获取失败");
                        }
                    })
                })
                break;
        }
    })
});