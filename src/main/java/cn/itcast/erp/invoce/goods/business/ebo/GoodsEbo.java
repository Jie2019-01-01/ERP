package cn.itcast.erp.invoce.goods.business.ebo;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import cn.itcast.erp.invoce.goods.business.ebi.GoodsEbi;
import cn.itcast.erp.invoce.goods.dao.dao.GoodsDao;
import cn.itcast.erp.invoce.goods.vo.GoodsModel;
import cn.itcast.erp.utils.base.BaseQueryModel;

@Transactional
public class GoodsEbo implements GoodsEbi {

	private GoodsDao goodsDao;
	public void setGoodsDao(GoodsDao goodsDao) {this.goodsDao = goodsDao;}

	public List<GoodsModel> list() {
		return goodsDao.list();
	}

	public void save(GoodsModel gm) {
		goodsDao.save(gm);
	}

	public void update(GoodsModel gm) {
		goodsDao.update(gm);
	}

	public GoodsModel getByUuid(Long uuid) {
		return goodsDao.getByUuid(uuid);
	}

	public void delete(GoodsModel gm) {
		goodsDao.delete(gm);
	}

	public List<GoodsModel> list(BaseQueryModel bqm, Integer curPage, Integer pageCount) {
		return goodsDao.list(bqm,curPage, pageCount);
	}

	public Integer getCount(BaseQueryModel bqm) {
		return goodsDao.getCount(bqm);
	}

}