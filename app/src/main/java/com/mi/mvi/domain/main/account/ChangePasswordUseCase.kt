package com.mi.mvi.domain.main.account

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.mi.mvi.data.models.AuthToken
import com.mi.mvi.data.repository.main.AccountRepository
import com.mi.mvi.data.response_handler.DataState
import com.mi.mvi.ui.main.account.state.AccountViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOn

@ExperimentalCoroutinesApi
class ChangePasswordUseCase(private val repository: AccountRepository) {

    fun invoke(
        token: AuthToken,
        currentPassword: String,
        newPassword: String,
        confirmNewPassword: String
    ): LiveData<DataState<AccountViewState>> {
        return repository.changePassword(token, currentPassword, newPassword, confirmNewPassword)
            .flowOn(Dispatchers.IO)
            .asLiveData()
    }
}