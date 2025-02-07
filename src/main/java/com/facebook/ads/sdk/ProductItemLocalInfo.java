/*
 * Copyright (c) Meta Platforms, Inc. and affiliates.
 * All rights reserved.
 *
 * This source code is licensed under the license found in the
 * LICENSE file in the root directory of this source tree.
 */

package com.facebook.ads.sdk;

import java.io.File;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import com.facebook.ads.sdk.APIException.MalformedResponseException;

/**
 * This class is auto-generated.
 *
 * For any issues or feature requests related to this class, please let us know
 * on github and we'll fix in our codegen framework. We'll not be able to accept
 * pull request for this class.
 *
 */
public class ProductItemLocalInfo extends APINode {
  @SerializedName("availability_circle_origin")
  private ProductItemLocalInfoLatLongShape mAvailabilityCircleOrigin = null;
  @SerializedName("availability_circle_radius")
  private Double mAvailabilityCircleRadius = null;
  @SerializedName("availability_circle_radius_unit")
  private String mAvailabilityCircleRadiusUnit = null;
  @SerializedName("availability_polygon_coordinates")
  private List<ProductItemLocalInfoLatLongShape> mAvailabilityPolygonCoordinates = null;
  @SerializedName("availability_postal_codes")
  private List<String> mAvailabilityPostalCodes = null;
  @SerializedName("availability_source")
  private String mAvailabilitySource = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("inferred_circle_origin")
  private ProductItemLocalInfoLatLongShape mInferredCircleOrigin = null;
  @SerializedName("inferred_circle_radius")
  private Double mInferredCircleRadius = null;
  protected static Gson gson = null;

  ProductItemLocalInfo() {
  }

  public ProductItemLocalInfo(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public ProductItemLocalInfo(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public ProductItemLocalInfo fetch() throws APIException{
    ProductItemLocalInfo newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static ProductItemLocalInfo fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<ProductItemLocalInfo> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static ProductItemLocalInfo fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<ProductItemLocalInfo> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<ProductItemLocalInfo> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<ProductItemLocalInfo>)(
      new APIRequest<ProductItemLocalInfo>(context, "", "/", "GET", ProductItemLocalInfo.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<ProductItemLocalInfo>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", ProductItemLocalInfo.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .executeAsyncBase();
  }

  private String getPrefixedId() {
    return getId();
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static ProductItemLocalInfo loadJSON(String json, APIContext context, String header) {
    ProductItemLocalInfo productItemLocalInfo = getGson().fromJson(json, ProductItemLocalInfo.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(productItemLocalInfo.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    productItemLocalInfo.context = context;
    productItemLocalInfo.rawValue = json;
    productItemLocalInfo.header = header;
    return productItemLocalInfo;
  }

  public static APINodeList<ProductItemLocalInfo> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<ProductItemLocalInfo> productItemLocalInfos = new APINodeList<ProductItemLocalInfo>(request, json, header);
    JsonArray arr;
    JsonObject obj;
    JsonParser parser = new JsonParser();
    Exception exception = null;
    try{
      JsonElement result = parser.parse(json);
      if (result.isJsonArray()) {
        // First, check if it's a pure JSON Array
        arr = result.getAsJsonArray();
        for (int i = 0; i < arr.size(); i++) {
          productItemLocalInfos.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return productItemLocalInfos;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                productItemLocalInfos.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            productItemLocalInfos.setPaging(previous, next);
            if (context.hasAppSecret()) {
              productItemLocalInfos.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              productItemLocalInfos.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
            };
          } else if (obj.get("data").isJsonObject()) {
            // Third, check if it's a JSON object with "data"
            obj = obj.get("data").getAsJsonObject();
            boolean isRedownload = false;
            for (String s : new String[]{"campaigns", "adsets", "ads"}) {
              if (obj.has(s)) {
                isRedownload = true;
                obj = obj.getAsJsonObject(s);
                for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
                  productItemLocalInfos.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              productItemLocalInfos.add(loadJSON(obj.toString(), context, header));
            }
          }
          return productItemLocalInfos;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              productItemLocalInfos.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return productItemLocalInfos;
        } else {
          // Fifth, check if it's an array of objects indexed by id
          boolean isIdIndexedArray = true;
          for (Map.Entry entry : obj.entrySet()) {
            String key = (String) entry.getKey();
            if (key.equals("__fb_trace_id__")) {
              continue;
            }
            JsonElement value = (JsonElement) entry.getValue();
            if (
              value != null &&
              value.isJsonObject() &&
              value.getAsJsonObject().has("id") &&
              value.getAsJsonObject().get("id") != null &&
              value.getAsJsonObject().get("id").getAsString().equals(key)
            ) {
              productItemLocalInfos.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return productItemLocalInfos;
          }

          // Sixth, check if it's pure JsonObject
          productItemLocalInfos.clear();
          productItemLocalInfos.add(loadJSON(json, context, header));
          return productItemLocalInfos;
        }
      }
    } catch (Exception e) {
      exception = e;
    }
    throw new MalformedResponseException(
      "Invalid response string: " + json,
      exception
    );
  }

  @Override
  public APIContext getContext() {
    return context;
  }

  @Override
  public void setContext(APIContext context) {
    this.context = context;
  }

  @Override
  public String toString() {
    return getGson().toJson(this);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public ProductItemLocalInfoLatLongShape getFieldAvailabilityCircleOrigin() {
    return mAvailabilityCircleOrigin;
  }

  public Double getFieldAvailabilityCircleRadius() {
    return mAvailabilityCircleRadius;
  }

  public String getFieldAvailabilityCircleRadiusUnit() {
    return mAvailabilityCircleRadiusUnit;
  }

  public List<ProductItemLocalInfoLatLongShape> getFieldAvailabilityPolygonCoordinates() {
    return mAvailabilityPolygonCoordinates;
  }

  public List<String> getFieldAvailabilityPostalCodes() {
    return mAvailabilityPostalCodes;
  }

  public String getFieldAvailabilitySource() {
    return mAvailabilitySource;
  }

  public String getFieldId() {
    return mId;
  }

  public ProductItemLocalInfoLatLongShape getFieldInferredCircleOrigin() {
    return mInferredCircleOrigin;
  }

  public Double getFieldInferredCircleRadius() {
    return mInferredCircleRadius;
  }



  public static class APIRequestGet extends APIRequest<ProductItemLocalInfo> {

    ProductItemLocalInfo lastResponse = null;
    @Override
    public ProductItemLocalInfo getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "availability_circle_origin",
      "availability_circle_radius",
      "availability_circle_radius_unit",
      "availability_polygon_coordinates",
      "availability_postal_codes",
      "availability_source",
      "id",
      "inferred_circle_origin",
      "inferred_circle_radius",
    };

    @Override
    public ProductItemLocalInfo parseResponse(String response, String header) throws APIException {
      return ProductItemLocalInfo.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public ProductItemLocalInfo execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ProductItemLocalInfo execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<ProductItemLocalInfo> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ProductItemLocalInfo> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, ProductItemLocalInfo>() {
           public ProductItemLocalInfo apply(ResponseWrapper result) {
             try {
               return APIRequestGet.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
      Runnable::run);
    };

    public APIRequestGet(String nodeId, APIContext context) {
      super(context, nodeId, "/", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGet setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGet setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGet requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGet requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGet requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGet requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGet requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGet requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGet requestAvailabilityCircleOriginField () {
      return this.requestAvailabilityCircleOriginField(true);
    }
    public APIRequestGet requestAvailabilityCircleOriginField (boolean value) {
      this.requestField("availability_circle_origin", value);
      return this;
    }
    public APIRequestGet requestAvailabilityCircleRadiusField () {
      return this.requestAvailabilityCircleRadiusField(true);
    }
    public APIRequestGet requestAvailabilityCircleRadiusField (boolean value) {
      this.requestField("availability_circle_radius", value);
      return this;
    }
    public APIRequestGet requestAvailabilityCircleRadiusUnitField () {
      return this.requestAvailabilityCircleRadiusUnitField(true);
    }
    public APIRequestGet requestAvailabilityCircleRadiusUnitField (boolean value) {
      this.requestField("availability_circle_radius_unit", value);
      return this;
    }
    public APIRequestGet requestAvailabilityPolygonCoordinatesField () {
      return this.requestAvailabilityPolygonCoordinatesField(true);
    }
    public APIRequestGet requestAvailabilityPolygonCoordinatesField (boolean value) {
      this.requestField("availability_polygon_coordinates", value);
      return this;
    }
    public APIRequestGet requestAvailabilityPostalCodesField () {
      return this.requestAvailabilityPostalCodesField(true);
    }
    public APIRequestGet requestAvailabilityPostalCodesField (boolean value) {
      this.requestField("availability_postal_codes", value);
      return this;
    }
    public APIRequestGet requestAvailabilitySourceField () {
      return this.requestAvailabilitySourceField(true);
    }
    public APIRequestGet requestAvailabilitySourceField (boolean value) {
      this.requestField("availability_source", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestInferredCircleOriginField () {
      return this.requestInferredCircleOriginField(true);
    }
    public APIRequestGet requestInferredCircleOriginField (boolean value) {
      this.requestField("inferred_circle_origin", value);
      return this;
    }
    public APIRequestGet requestInferredCircleRadiusField () {
      return this.requestInferredCircleRadiusField(true);
    }
    public APIRequestGet requestInferredCircleRadiusField (boolean value) {
      this.requestField("inferred_circle_radius", value);
      return this;
    }
  }


  synchronized /*package*/ static Gson getGson() {
    if (gson != null) {
      return gson;
    } else {
      gson = new GsonBuilder()
        .excludeFieldsWithModifiers(Modifier.STATIC)
        .excludeFieldsWithModifiers(Modifier.PROTECTED)
        .disableHtmlEscaping()
        .create();
    }
    return gson;
  }

  public ProductItemLocalInfo copyFrom(ProductItemLocalInfo instance) {
    this.mAvailabilityCircleOrigin = instance.mAvailabilityCircleOrigin;
    this.mAvailabilityCircleRadius = instance.mAvailabilityCircleRadius;
    this.mAvailabilityCircleRadiusUnit = instance.mAvailabilityCircleRadiusUnit;
    this.mAvailabilityPolygonCoordinates = instance.mAvailabilityPolygonCoordinates;
    this.mAvailabilityPostalCodes = instance.mAvailabilityPostalCodes;
    this.mAvailabilitySource = instance.mAvailabilitySource;
    this.mId = instance.mId;
    this.mInferredCircleOrigin = instance.mInferredCircleOrigin;
    this.mInferredCircleRadius = instance.mInferredCircleRadius;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ProductItemLocalInfo> getParser() {
    return new APIRequest.ResponseParser<ProductItemLocalInfo>() {
      public APINodeList<ProductItemLocalInfo> parseResponse(String response, APIContext context, APIRequest<ProductItemLocalInfo> request, String header) throws MalformedResponseException {
        return ProductItemLocalInfo.parseResponse(response, context, request, header);
      }
    };
  }
}
