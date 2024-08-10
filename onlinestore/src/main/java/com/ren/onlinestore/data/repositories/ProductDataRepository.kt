package com.ren.onlinestore.data.repositories

import com.ren.onlinestore.data.database.dao.ProductDao
import com.ren.onlinestore.data.network.RetrofitClient
import com.ren.onlinestore.data.network.models.ProductDTO
import com.ren.onlinestore.data.network.models.toProduct
import com.ren.onlinestore.models.Product
import com.ren.onlinestore.utils.Result
import com.ren.onlinestore.utils.asNetworkError
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response

class ProductDataRepository(
    private val dao: ProductDao,
) : ProductRepository {

    override fun getProducts(
        onResult: (result: Result<List<Product>>) -> Unit,
    ) {
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
                        onResult(Result.Success(products))
                    } else {
                        onResult(Result.Error(HttpException(response).asNetworkError()))
                    }
                }

                override fun onFailure(call: Call<List<ProductDTO>>, throwable: Throwable) {
                    throwable.printStackTrace()
                    onResult(Result.Error(throwable.asNetworkError()))
                }
            })
    }
}