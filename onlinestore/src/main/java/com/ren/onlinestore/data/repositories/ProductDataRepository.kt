package com.ren.onlinestore.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ren.onlinestore.data.database.dao.ProductDao
import com.ren.onlinestore.data.network.RetrofitClient
import com.ren.onlinestore.data.network.models.ProductDTO
import com.ren.onlinestore.data.network.models.toProduct
import com.ren.onlinestore.models.Product
import com.ren.onlinestore.models.ProductRepository
import com.ren.onlinestore.utils.HttpCode
import com.ren.onlinestore.utils.NetworkError
import com.ren.onlinestore.utils.Result
import com.ren.onlinestore.utils.asNetworkError
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class ProductDataRepository(
    private val dao: ProductDao,
) : ProductRepository {

    override fun getProducts(): LiveData<List<Product>> {
        val productsLiveData = MutableLiveData<Result<List<Product>>>()
        RetrofitClient.productApiService.getAllProducts()
            .enqueue(object : Callback<List<ProductDTO>> {
                override fun onResponse(
                    call: Call<List<ProductDTO>>,
                    response: Response<List<ProductDTO>>
                ) {
                    if (response.isSuccessful && response.body() != null) {
                        val products = response.body()!!.map {
                            it.toProduct()
                        }
                        productsLiveData.value = Result.Success(products)
                    } else {

                    }
                }

                override fun onFailure(call: Call<List<ProductDTO>>, throwable: Throwable) {
                    throwable.asNetworkError()
                }
            })
    }
}