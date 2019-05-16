package com.destroypop.presentation

interface ServiceLocatorView<T: ServiceLocator> {

    fun getServiceLocator(): T

}