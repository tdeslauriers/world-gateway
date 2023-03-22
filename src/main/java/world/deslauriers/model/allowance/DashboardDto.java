package world.deslauriers.model.allowance;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import java.util.Set;

@Serdeable
public class DashboardDto extends AllowanceDto{

    // weekly task stats
    @Nullable
    private Long total;  // thus far: many will not have been created yet
    @Nullable
    private Long totalCompleted;

    @Nullable Double percentageCompleted;

    @Nullable
    private Long totalSatisfactory; // <= total completed

    @Nullable
    private Double percentageSatisfactory;

    // assigned
    Set<Tasktype> assigned;

    public DashboardDto() {
    }

    public DashboardDto(Double balance, String userUuid, @Nullable Long total, @Nullable Long totalCompleted, @Nullable Double percentageCompleted, @Nullable Long totalSatisfactory, @Nullable Double percentageSatisfactory, Set<Tasktype> assigned) {
        super(balance, userUuid);
        this.total = total;
        this.totalCompleted = totalCompleted;
        this.percentageCompleted = percentageCompleted;
        this.totalSatisfactory = totalSatisfactory;
        this.percentageSatisfactory = percentageSatisfactory;
        this.assigned = assigned;
    }

    public DashboardDto(Long id, Double balance, String userUuid, String username, String firstname, String lastname, Integer age, @Nullable Long total, @Nullable Long totalCompleted, @Nullable Double percentageCompleted, @Nullable Long totalSatisfactory, @Nullable Double percentageSatisfactory) {
        super(id, balance, userUuid, username, firstname, lastname, age);
        this.total = total;
        this.totalCompleted = totalCompleted;
        this.percentageCompleted = percentageCompleted;
        this.totalSatisfactory = totalSatisfactory;
        this.percentageSatisfactory = percentageSatisfactory;
    }



    public DashboardDto(@Nullable Long total, @Nullable Long totalCompleted, @Nullable Double percentageCompleted, @Nullable Long totalSatisfactory, @Nullable Double percentageSatisfactory) {
        this.total = total;
        this.totalCompleted = totalCompleted;
        this.percentageCompleted = percentageCompleted;
        this.totalSatisfactory = totalSatisfactory;
        this.percentageSatisfactory = percentageSatisfactory;
    }

    @Nullable
    public Long getTotal() {
        return total;
    }

    public void setTotal(@Nullable Long total) {
        this.total = total;
    }

    @Nullable
    public Long getTotalCompleted() {
        return totalCompleted;
    }

    public void setTotalCompleted(@Nullable Long totalCompleted) {
        this.totalCompleted = totalCompleted;
    }

    @Nullable
    public Double getPercentageCompleted() {
        return percentageCompleted;
    }

    public void setPercentageCompleted(@Nullable Double percentageCompleted) {
        this.percentageCompleted = percentageCompleted;
    }

    @Nullable
    public Long getTotalSatisfactory() {
        return totalSatisfactory;
    }

    public void setTotalSatisfactory(@Nullable Long totalSatisfactory) {
        this.totalSatisfactory = totalSatisfactory;
    }

    @Nullable
    public Double getPercentageSatisfactory() {
        return percentageSatisfactory;
    }

    public void setPercentageSatisfactory(@Nullable Double percentageSatisfactory) {
        this.percentageSatisfactory = percentageSatisfactory;
    }

    public Set<Tasktype> getAssigned() {
        return assigned;
    }

    public void setAssigned(Set<Tasktype> assigned) {
        this.assigned = assigned;
    }

    @Override
    public String toString() {
        return "DashboardDto{" +
                "total=" + total +
                ", totalCompleted=" + totalCompleted +
                ", percentageCompleted=" + percentageCompleted +
                ", totalSatisfactory=" + totalSatisfactory +
                ", percentageSatisfactory=" + percentageSatisfactory +
                ", assigned=" + assigned +
                '}';
    }
}
