package com.dream.mask.datasource.change;

public class DynamicDataSourceThreadLocal {
    
    private static final ThreadLocal<String> DATASOURCE_THREAD_LOCAL = new ThreadLocal<>();
    
    public static void setDatasource(String datasourceName){
        DATASOURCE_THREAD_LOCAL.set(datasourceName);
    }
    
    public static String getDataSource(){
        return DATASOURCE_THREAD_LOCAL.get();
    }
}
