### redis启动命令
    1. 命令行定位到redis安装目录，如：
        cd D:
        cd redis\redis-2.8.17
    2. 执行指令：
        redis-server.exe redis.windows.conf

### 登录用户介绍
    1-管理员，2-志愿者，3-用户
    密码为：1234
    
### 配置文件介绍
    数据库配置文件：resources/db.properties
    redis配置文件：resources/config/redis.properties
    
### 短信验证码发送功能介绍
    短信验证码调用的阿里云短信服务
    此功能需要配置两个KEY，配置文件；resources/config/constant-config.properties
        accessKeyId=XXXXXXX
        accessSecret=XXXXXXXX
        
### 