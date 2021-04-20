package com.image.portal.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * ShareAbleData
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-03-24T09:41:07.734618300-05:00[America/Chicago]")
public class ShareAbleData {
    @JsonProperty("shareAbleDataType")
    private String shareAbleDataType;

    @JsonProperty("isShareable")
    private Boolean isShareable;

    public ShareAbleData shareAbleDataType(String shareAbleDataType) {
        this.shareAbleDataType = shareAbleDataType;
        return this;
    }

    /**
     * Get shareAbleDataType
     *
     * @return shareAbleDataType
     */
    @ApiModelProperty(required = true, value = "")
    @NotNull


    public String getShareAbleDataType() {
        return shareAbleDataType;
    }

    public void setShareAbleDataType(String shareAbleDataType) {
        this.shareAbleDataType = shareAbleDataType;
    }

    public ShareAbleData isShareable(Boolean isShareable) {
        this.isShareable = isShareable;
        return this;
    }

    /**
     * Get isShareable
     *
     * @return isShareable
     */
    @ApiModelProperty(required = true, value = "")
    @NotNull


    public Boolean getIsShareable() {
        return isShareable;
    }

    public void setIsShareable(Boolean isShareable) {
        this.isShareable = isShareable;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ShareAbleData shareAbleData = (ShareAbleData) o;
        return Objects.equals(this.shareAbleDataType, shareAbleData.shareAbleDataType) &&
                Objects.equals(this.isShareable, shareAbleData.isShareable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shareAbleDataType, isShareable);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ShareAbleData {\n");

        sb.append("    shareAbleDataType: ").append(toIndentedString(shareAbleDataType)).append("\n");
        sb.append("    isShareable: ").append(toIndentedString(isShareable)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

