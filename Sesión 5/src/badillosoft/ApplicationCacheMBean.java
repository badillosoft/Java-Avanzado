/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package badillosoft;

/**
 *
 * @author root
 */
public interface ApplicationCacheMBean {
    
    public int getMaxCacheSize();
    
    public void setMaxCacheSize(int value);
    
    public int size();
    
    public void clear();
    
}
