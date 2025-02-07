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
public class BusinessCreativeFolder extends APINode {
  @SerializedName("business")
  private Business mBusiness = null;
  @SerializedName("creation_time")
  private String mCreationTime = null;
  @SerializedName("creative_insight_permissions")
  private List<Map<String, String>> mCreativeInsightPermissions = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("media_library_url")
  private String mMediaLibraryUrl = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("owner_business")
  private Business mOwnerBusiness = null;
  protected static Gson gson = null;

  BusinessCreativeFolder() {
  }

  public BusinessCreativeFolder(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public BusinessCreativeFolder(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public BusinessCreativeFolder fetch() throws APIException{
    BusinessCreativeFolder newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static BusinessCreativeFolder fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<BusinessCreativeFolder> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static BusinessCreativeFolder fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<BusinessCreativeFolder> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<BusinessCreativeFolder> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<BusinessCreativeFolder>)(
      new APIRequest<BusinessCreativeFolder>(context, "", "/", "GET", BusinessCreativeFolder.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<BusinessCreativeFolder>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", BusinessCreativeFolder.getParser())
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
  public static BusinessCreativeFolder loadJSON(String json, APIContext context, String header) {
    BusinessCreativeFolder businessCreativeFolder = getGson().fromJson(json, BusinessCreativeFolder.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(businessCreativeFolder.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    businessCreativeFolder.context = context;
    businessCreativeFolder.rawValue = json;
    businessCreativeFolder.header = header;
    return businessCreativeFolder;
  }

  public static APINodeList<BusinessCreativeFolder> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<BusinessCreativeFolder> businessCreativeFolders = new APINodeList<BusinessCreativeFolder>(request, json, header);
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
          businessCreativeFolders.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return businessCreativeFolders;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                businessCreativeFolders.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            businessCreativeFolders.setPaging(previous, next);
            if (context.hasAppSecret()) {
              businessCreativeFolders.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              businessCreativeFolders.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  businessCreativeFolders.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              businessCreativeFolders.add(loadJSON(obj.toString(), context, header));
            }
          }
          return businessCreativeFolders;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              businessCreativeFolders.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return businessCreativeFolders;
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
              businessCreativeFolders.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return businessCreativeFolders;
          }

          // Sixth, check if it's pure JsonObject
          businessCreativeFolders.clear();
          businessCreativeFolders.add(loadJSON(json, context, header));
          return businessCreativeFolders;
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


  public Business getFieldBusiness() {
    if (mBusiness != null) {
      mBusiness.context = getContext();
    }
    return mBusiness;
  }

  public String getFieldCreationTime() {
    return mCreationTime;
  }

  public List<Map<String, String>> getFieldCreativeInsightPermissions() {
    return mCreativeInsightPermissions;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldMediaLibraryUrl() {
    return mMediaLibraryUrl;
  }

  public String getFieldName() {
    return mName;
  }

  public Business getFieldOwnerBusiness() {
    if (mOwnerBusiness != null) {
      mOwnerBusiness.context = getContext();
    }
    return mOwnerBusiness;
  }



  public static class APIRequestGet extends APIRequest<BusinessCreativeFolder> {

    BusinessCreativeFolder lastResponse = null;
    @Override
    public BusinessCreativeFolder getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "business",
      "creation_time",
      "creative_insight_permissions",
      "description",
      "id",
      "media_library_url",
      "name",
      "owner_business",
    };

    @Override
    public BusinessCreativeFolder parseResponse(String response, String header) throws APIException {
      return BusinessCreativeFolder.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public BusinessCreativeFolder execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public BusinessCreativeFolder execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<BusinessCreativeFolder> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<BusinessCreativeFolder> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, BusinessCreativeFolder>() {
           public BusinessCreativeFolder apply(ResponseWrapper result) {
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

    public APIRequestGet requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGet requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGet requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGet requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGet requestCreativeInsightPermissionsField () {
      return this.requestCreativeInsightPermissionsField(true);
    }
    public APIRequestGet requestCreativeInsightPermissionsField (boolean value) {
      this.requestField("creative_insight_permissions", value);
      return this;
    }
    public APIRequestGet requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGet requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestMediaLibraryUrlField () {
      return this.requestMediaLibraryUrlField(true);
    }
    public APIRequestGet requestMediaLibraryUrlField (boolean value) {
      this.requestField("media_library_url", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestOwnerBusinessField () {
      return this.requestOwnerBusinessField(true);
    }
    public APIRequestGet requestOwnerBusinessField (boolean value) {
      this.requestField("owner_business", value);
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

  public BusinessCreativeFolder copyFrom(BusinessCreativeFolder instance) {
    this.mBusiness = instance.mBusiness;
    this.mCreationTime = instance.mCreationTime;
    this.mCreativeInsightPermissions = instance.mCreativeInsightPermissions;
    this.mDescription = instance.mDescription;
    this.mId = instance.mId;
    this.mMediaLibraryUrl = instance.mMediaLibraryUrl;
    this.mName = instance.mName;
    this.mOwnerBusiness = instance.mOwnerBusiness;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<BusinessCreativeFolder> getParser() {
    return new APIRequest.ResponseParser<BusinessCreativeFolder>() {
      public APINodeList<BusinessCreativeFolder> parseResponse(String response, APIContext context, APIRequest<BusinessCreativeFolder> request, String header) throws MalformedResponseException {
        return BusinessCreativeFolder.parseResponse(response, context, request, header);
      }
    };
  }
}
