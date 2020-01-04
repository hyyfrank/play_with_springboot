package com.autodesk.www.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

public class JsonWrapResult {
  // 定义jackson对象
  private static final ObjectMapper MAPPER = new ObjectMapper();

  // 响应业务状态
  private Integer status;

  // 响应消息
  private String msg;

  // 响应中的数据
  private Object data;

  private String ok; // 不使用

  public JsonWrapResult() {}

  public JsonWrapResult(Integer status, String msg, Object data) {
    this.status = status;
    this.msg = msg;
    this.data = data;
  }

  public JsonWrapResult(Object data) {
    this.status = 200;
    this.msg = "OK";
    this.data = data;
  }

  public static JsonWrapResult build(Integer status, String msg, Object data) {
    return new JsonWrapResult(status, msg, data);
  }

  public static JsonWrapResult ok(Object data) {
    return new JsonWrapResult(data);
  }

  public static JsonWrapResult ok() {
    return new JsonWrapResult(null);
  }

  public static JsonWrapResult errorMsg(String msg) {
    return new JsonWrapResult(500, msg, null);
  }

  public static JsonWrapResult errorMap(Object data) {
    return new JsonWrapResult(501, "error", data);
  }

  public static JsonWrapResult errorTokenMsg(String msg) {
    return new JsonWrapResult(502, msg, null);
  }

  public static JsonWrapResult errorException(String msg) {
    return new JsonWrapResult(555, msg, null);
  }

  public static JsonWrapResult formatToPojo(String jsonData, Class<?> clazz) {
    try {
      if (clazz == null) {
        return MAPPER.readValue(jsonData, JsonWrapResult.class);
      }
      JsonNode jsonNode = MAPPER.readTree(jsonData);
      JsonNode data = jsonNode.get("data");
      Object obj = null;
      if (clazz != null) {
        if (data.isObject()) {
          obj = MAPPER.readValue(data.traverse(), clazz);
        } else if (data.isTextual()) {
          obj = MAPPER.readValue(data.asText(), clazz);
        }
      }
      return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
    } catch (Exception e) {
      return null;
    }
  }

  public static JsonWrapResult format(String json) {
    try {
      return MAPPER.readValue(json, JsonWrapResult.class);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public static JsonWrapResult formatToList(String jsonData, Class<?> clazz) {
    try {
      JsonNode jsonNode = MAPPER.readTree(jsonData);
      JsonNode data = jsonNode.get("data");
      Object obj = null;
      if (data.isArray() && data.size() > 0) {
        obj =
            MAPPER.readValue(
                data.traverse(),
                MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
      }
      return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
    } catch (Exception e) {
      return null;
    }
  }

  public Boolean isOK() {
    return this.status == 200;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  public String getOk() {
    return ok;
  }

  public void setOk(String ok) {
    this.ok = ok;
  }
}
