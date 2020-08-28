
**葬月,多模块开发文档**


**简介**：<p>多模块开发文档</p>


**HOST**:localhost:8080


**联系人**:


**Version**:1.0.0

**接口路径**：/v2/api-docs


# 后台用户接口

## 添加用户


**接口描述**:


**接口地址**:`/sys-user/add`


**请求方式**：`POST`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`


**请求示例**：
```json
{
	"headImg": "",
	"id": 0,
	"password": "",
	"phone": "",
	"realName": "",
	"roles": [],
	"username": ""
}
```


**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|sysUser| sysUser  | body | true |添加用户的实体  | 添加用户的实体   |

**schema属性说明**


**添加用户的实体**

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|headImg| 头像地址  | body | false |string  |    |
|id| 主键  | body | false |integer(int64)  |    |
|password| 密码  | body | false |string  |    |
|phone| 手机号  | body | false |string  |    |
|realName| 真实名字  | body | false |string  |    |
|roles| 用户的所有角色的id  | body | false |array  |    |
|username| 用户名  | body | false |string  |    |

**响应示例**:

```json
{
	"code": 0,
	"mes": "",
	"t": {}
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|code| 响应状码  |integer(int32)  | integer(int32)   |
|mes| 响应描述  |string  |    |
|t| 返回数据  |object  |    |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |统一返回实体«object»|
| 201 | Created  ||
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 手机号是否存在


**接口描述**:


**接口地址**:`/sys-user/has-phone`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|phone| phone  | body | true |string  |    |

**响应示例**:

```json
{
	"code": 0,
	"mes": "",
	"t": true
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|code| 响应状码  |integer(int32)  | integer(int32)   |
|mes| 响应描述  |string  |    |
|t| 返回数据  |boolean  |    |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |统一返回实体«boolean»|
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 用户名是否存在


**接口描述**:


**接口地址**:`/sys-user/has-username`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|username| username  | body | true |string  |    |

**响应示例**:

```json
{
	"code": 0,
	"mes": "",
	"t": true
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|code| 响应状码  |integer(int32)  | integer(int32)   |
|mes| 响应描述  |string  |    |
|t| 返回数据  |boolean  |    |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |统一返回实体«boolean»|
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
