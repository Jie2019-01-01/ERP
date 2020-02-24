package cn.itcast.erp.invoce.goodstype.business.ebo;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.erp.invoce.goods.dao.dao.GoodsDao;
import cn.itcast.erp.invoce.goods.vo.GoodsModel;
import cn.itcast.erp.invoce.goodstype.business.ebi.GoodsTypeEbi;
import cn.itcast.erp.invoce.goodstype.dao.dao.GoodsTypeDao;
import cn.itcast.erp.invoce.goodstype.vo.GoodsTypeModel;
import cn.itcast.erp.utils.base.BaseQueryModel;

@Transactional
public class GoodsTypeEbo implements GoodsTypeEbi {

	private GoodsTypeDao goodsTypeDao;
	public void setGoodsTypeDao(GoodsTypeDao goodsTypeDao) {this.goodsTypeDao = goodsTypeDao;}
	private GoodsDao goodsDao;
	public void setGoodsDao(GoodsDao goodsDao) {this.goodsDao = goodsDao;}

	public List<GoodsTypeModel> list() {
		return goodsTypeDao.list();
	}

	public void save(GoodsTypeModel gm) {
		goodsTypeDao.save(gm);
	}

	public void update(GoodsTypeModel gm) {
		goodsTypeDao.update(gm);
	}

	public GoodsTypeModel getByUuid(Long uuid) {
		return goodsTypeDao.getByUuid(uuid);
	}

	public void delete(GoodsTypeModel gm) {
		goodsTypeDao.delete(gm);
	}

	public List<GoodsTypeModel> list(BaseQueryModel bqm, Integer curPage, Integer pageCount) {
		return goodsTypeDao.list(bqm,curPage, pageCount);
	}

	public Integer getCount(BaseQueryModel bqm) {
		return goodsTypeDao.getCount(bqm);
	}

	public List<GoodsTypeModel> getBySupplier(Long uuid) {
		return goodsTypeDao.getBySupplier(uuid);
	}

	public List<GoodsTypeModel> getNotNullBySupplier(Long uuid) {
		return goodsTypeDao.getNotNullBySupplier(uuid);
	}

	public List<GoodsTypeModel> getBySupplierUnion(Long supplierUuid, List<Long> gmUuids) {
		// 根据供应商获取类别的集合
		List<GoodsTypeModel> gtmList = goodsTypeDao.getNotNullBySupplier(supplierUuid);
		gtm:
		for(int i=gtmList.size()-1; i>=0; i--) {
			// 根据类别uuid获取商品
			List<GoodsModel> gmList = goodsDao.getByGtm(gtmList.get(i).getUuid());
			for(GoodsModel gm: gmList) {
				// 如果该商品集合中存在未使用的商品，该商品类别保留，开始下一个类别判断
				if(!gmUuids.contains(gm.getUuid())) {
					continue gtm;
				}
			}
			// 商品集合遍历一圈后，不存在未使用过的商品
			// 那么该类别没有存在的必要，直接从类别集合中剔除
			gtmList.remove(i);
		}
		return gtmList;
	}

}







