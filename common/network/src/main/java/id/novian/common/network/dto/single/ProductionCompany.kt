package id.novian.common.network.dto.single


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class ProductionCompany(
    @SerializedName("id")
    val id: Int,
    @SerializedName("logo_path")
    val logoPath: Any,
    @SerializedName("name")
    val name: String,
    @SerializedName("origin_country")
    val originCountry: String
)