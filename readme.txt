###基于jdk1.7的http远程服务调用####
使用方法：

获取token(如不需要获取token跳过此步骤)
RequestUtil.getToken(tokenUrl,paramMap);

调用服务 获取json数组
1.在application.properties文件中配置返回数据中要提取的key(例如：返回数据都在data或者在results下面)
service.data=results  ##即要获取的数据都在results下面
2.使用RequestUtil工具类请求获取数据
RequestUtil.getData(serviceUrl,paramMap);



