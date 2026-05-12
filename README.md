# Geam Web

`Geam Web` 是一个适合小游戏网页项目的全栈脚手架，包含前端、后端、数据库、JWT 鉴权与 Docker 部署基础结构。

这个框架适合你继续开发成以下类型的项目：

- 答题闯关
- 记忆翻牌
- 反应测速
- 点击得分类小游戏
- 带排行榜的休闲网页游戏

## 技术栈

- 前端：Vue 3、Vue Router 4、Vuex 4、Element Plus、Axios
- 后端：Spring Boot 3、Spring Security、JWT、MyBatis-Plus
- 数据库：MySQL 8
- 部署：Docker、Docker Compose、Nginx

## 为什么这里改成 Element Plus

你刚刚希望前端切到 `Vue 3`，这一点完全可以。

但是需要注意：

- `Element UI` 主要适配 `Vue 2`
- `Vue 3` 对应的官方生态组件库应使用 `Element Plus`

所以现在这个项目的前端框架已经按：

`Vue 3 + Element Plus`

来组织。

## 已包含的基础能力

- 用户注册
- 用户登录
- JWT 鉴权
- 游戏列表接口
- 游戏详情接口
- 分数提交接口
- 排行榜接口骨架
- 后台扩展入口
- 数据库建表 SQL
- Docker 容器化结构
- 技术栈使用与注意事项指南

## 目录结构

```text
Geam_web/
  frontend/                前端项目
  backend/                 后端项目
  sql/                     数据库脚本
  docs/                    使用指南
  docker-compose.yml       容器编排
```

## 快速启动

### 1. 初始化数据库

先创建数据库：

```sql
CREATE DATABASE geam_web DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

然后执行：

```sql
SOURCE sql/schema.sql;
```

### 2. 配置后端

编辑文件：

`backend/src/main/resources/application.yml`

需要重点确认：

- MySQL 连接地址
- 用户名和密码
- JWT 密钥

### 3. 启动后端

```bash
cd backend
mvn spring-boot:run
```

默认接口地址：

`http://localhost:8080/api`

### 4. 启动前端

```bash
cd frontend
npm install
npm run dev
```

默认前端地址：

`http://localhost:8081`

### 5. 使用 Docker 启动

```bash
docker compose up --build
```

## 推荐开发顺序

1. 先跑通注册、登录、JWT
2. 接通前端登录页与注册页
3. 做一个最小可运行小游戏页面
4. 接入成绩提交接口
5. 做排行榜页面
6. 增加个人中心和管理页
7. 最后补 Docker 部署

## 推荐先做的小游戏

如果你想尽快做出一个完整项目，优先推荐：

### 1. 答题闯关

优点：

- 最容易做数据库设计
- 最容易体现前后端交互
- 最容易做排行榜

### 2. 反应测速

优点：

- 前端交互简单
- 分数提交逻辑清晰
- 页面效果容易做得直观

## 文档说明

- 技术栈使用指南：[docs/STACK_GUIDE.md](./docs/STACK_GUIDE.md)
- 数据库脚本：[sql/schema.sql](./sql/schema.sql)

## 当前脚手架说明

- 这是一个“可继续开发”的完整项目骨架，不是最终成品
- 重点已经帮你搭好模块边界、接口分层、部署结构和文档
- 你可以在这个基础上继续填充具体游戏玩法
