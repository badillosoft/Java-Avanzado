/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package badillosoft;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author root
 */
public class ApplicationCache implements ApplicationCacheMBean {
    
    protected int maxCacheSize = 100;
    protected List cache = new ArrayList();
    
    @Override
    public int getMaxCacheSize() {
        return maxCacheSize;
    }
    
    @Override
    public void setMaxCacheSize(int value) {
        maxCacheSize = value;
    }
    
    @Override
    public int size() {
        return cache.size();
    }
    
    public void clear() {
        cache.clear();
    }
    
    public void add(Object o) {
        if (cache.size() >= maxCacheSize) {
            cache.remove(0);
        }
        
        cache.add(o);
    }
}
