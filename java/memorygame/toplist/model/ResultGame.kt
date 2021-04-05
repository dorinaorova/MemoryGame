package hu.bme.aut.android.memorygame.toplist.model

import android.os.Parcel
import android.os.Parcelable

class ResultGame(
    val id: Long? = null,
    var date: String?,
    var seconds: Int,
    var mode: String?
): Parcelable {
    constructor(source: Parcel) : this(
        source.readLong(),
        source.readString(),
        source.readInt(),
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(date)
        writeInt(seconds)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<ResultGame> = object : Parcelable.Creator<ResultGame> {
            override fun createFromParcel(source: Parcel): ResultGame = ResultGame(source)
            override fun newArray(size: Int): Array<ResultGame?> = arrayOfNulls(size)
        }
    }

}